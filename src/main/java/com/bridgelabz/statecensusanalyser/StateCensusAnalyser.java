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

	public StateCensusAnalyser(String STATE_CODE_CSV_FILE_PATH) {
		this.STATE_CODE_CSV_FILE_PATH = STATE_CODE_CSV_FILE_PATH;
	}

	public int readStateData() throws CsvException {
		int count = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(STATE_CODE_CSV_FILE_PATH));) {
			CsvToBean<CSVStates> csvToBean = new CsvToBeanBuilder(reader).withIgnoreLeadingWhiteSpace(true)
					.withType(CSVStates.class).build();

			Iterator<CSVStates> stateIterator = csvToBean.iterator();

			while (stateIterator.hasNext()) {
				CSVStates state = stateIterator.next();
				count++;
			}
		} catch (NoSuchFileException e) {
			throw new CsvException(CsvException.ExceptionType.FILE_NOT_FOUND, "Such type file doesn't exist",
					e.getCause());
		} catch (RuntimeException e) {
            throw new CsvException(CsvException.ExceptionType.NULL_DATA_FOUND, "binding of file to failed", e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new CsvException(CsvException.ExceptionType.NULL_DATA_FOUND, "binding of file to failed", e.getCause());
		}
		return count;
	}
}
