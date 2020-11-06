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
	String CSV_FILE_PATH;

	public StateCensusAnalyser(String CSV_FILE_PATH) {
		this.CSV_FILE_PATH = CSV_FILE_PATH;
	}

	CSVStatesCensus csvStatesCensus = new CSVStatesCensus();

	public <E> int readStateData(Class<E> eClass) throws CensusCsvException {
		int count = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))) {
			@SuppressWarnings("unchecked")
			CsvToBean<E> csvToBean = new CsvToBeanBuilder(reader).withIgnoreLeadingWhiteSpace(true).withType(eClass)
					.build();
			@SuppressWarnings("rawtypes")
			Iterator stateIterator = csvToBean.iterator();
			while (stateIterator.hasNext()) {
				@SuppressWarnings("unchecked")
				E csv = (E) stateIterator.next();
				count++;
				if (csv instanceof CSVStatesCensus) {
					if (((CSVStatesCensus) csv).getState() == null || ((CSVStatesCensus) csv).getAreaInSqKm() == null
							|| ((CSVStatesCensus) csv).getDensityPerSqKm() == null
							|| ((CSVStatesCensus) csv).getPopulation() == null) {
						throw new CensusCsvException("Exception due to Header or mismatch data",
								CensusCsvException.ExceptionType.NO_SUCH_HEADER);
					}
				}
				if (csv instanceof CSVStatesCensus) {
					if (((CSVStatesCensus) csv).getState() == null || ((CSVStatesCensus) csv).getAreaInSqKm() == null
							|| ((CSVStatesCensus) csv).getDensityPerSqKm() == null
							|| ((CSVStatesCensus) csv).getPopulation() == null) {
						throw new CensusCsvException("Exception due to Header or mismatch data",
								CensusCsvException.ExceptionType.NO_SUCH_HEADER);
					}
				}
			}
		} catch (NoSuchFileException e) {
			if (CSV_FILE_PATH.contains(".csv")) {
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

}
