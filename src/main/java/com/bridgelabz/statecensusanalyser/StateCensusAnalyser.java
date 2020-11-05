package com.bridgelabz.statecensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	private String STATE_CODE_CSV_FILE_PATH = "/StateCensusAnalyser/src/main/resources/IndiaStateCode.csv";
	private String STATE_CENSUS_INFO_CSV_FILE_PATH = "/StateCensusAnalyser/src/main/resources/IndiaStateCensusData.csv";

	public StateCensusAnalyser(String STATE_CODE_CSV_FILE_PATH) {
		this.STATE_CODE_CSV_FILE_PATH = STATE_CODE_CSV_FILE_PATH;
	}

	public int readStateData() throws CensusCsvException {
		int count = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(STATE_CODE_CSV_FILE_PATH));) {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			CsvToBean<CSVStates> csvToBean = new CsvToBeanBuilder(reader).withIgnoreLeadingWhiteSpace(true)
					.withType(CSVStates.class).build();

			Iterator<CSVStates> stateIterator = csvToBean.iterator();

			while (stateIterator.hasNext()) {
				CSVStates csvStates = stateIterator.next();
				count++;
				if (csvStates.getSrNo() == 0 || csvStates.getStateName() == null || csvStates.getTIN() == null
						|| csvStates.getStateCode() == null) {
					throw new CensusCsvException("Exception due to Header",
							CensusCsvException.ExceptionType.NO_SUCH_HEADER);
				}
			}
		} catch (NoSuchFileException e) {
			if (STATE_CODE_CSV_FILE_PATH.contains(".csv")) {
				throw new CensusCsvException("Please enter proper file name",
						CensusCsvException.ExceptionType.NO_SUCH_FILE);
			}
		} catch (RuntimeException e) {
			throw new CensusCsvException("Exception due to incorrect delimiter position",
					CensusCsvException.ExceptionType.NO_SUCH_FIELD);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int readStateCensusInformation() throws CensusCsvException {
		int count = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(STATE_CENSUS_INFO_CSV_FILE_PATH))) {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			CsvToBean<CSVStatesCensus> csvToBean = new CsvToBeanBuilder(reader).withIgnoreLeadingWhiteSpace(true)
					.withType(CSVStatesCensus.class).build();
			Iterator<CSVStatesCensus> stateIterator = csvToBean.iterator();
			while (stateIterator.hasNext()) {
				@SuppressWarnings("unused")
				CSVStatesCensus csvStatesCensus = stateIterator.next();
				count++;
			}
		} catch (NoSuchFileException e) {
			if (STATE_CENSUS_INFO_CSV_FILE_PATH.contains(".csv")) {
				throw new CensusCsvException("Please enter proper file name",
						CensusCsvException.ExceptionType.NO_SUCH_FILE);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return count;
	}
}
