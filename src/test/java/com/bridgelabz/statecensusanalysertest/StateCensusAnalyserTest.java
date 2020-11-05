package com.bridgelabz.statecensusanalysertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.statecensusanalyser.CsvException;
import com.bridgelabz.statecensusanalyser.StateCensusAnalyser;

public class StateCensusAnalyserTest {
	private String STATE_CODE_CSV_FILE = "/StateCensusAnalyser/src/main/resources/IndiaStateCode.csv";
	private String WRONG_STATE_CODE_CSV_FILE = "/StateCensusAnalyser/src/main/resources/IndiaStateCode12.csv";
	private String INCORRECT_FILE = "/StateCensusAnalyser/gradlew.bat";

	public void checkToEnsure_NumberOfRecordsMatches() throws CsvException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CODE_CSV_FILE);
		Assert.assertEquals(37, stateCensusAnalyser.readStateData());
	}

	@Test
	public void givenWrongFileName_ShouldThrowNoSuchFileException() throws CsvException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(WRONG_STATE_CODE_CSV_FILE);
		int checkNumberOfRecords = stateCensusAnalyser.readStateData();
		Assert.assertEquals(37, stateCensusAnalyser.readStateData());
	}

	@Test
	public void givenWrongFileName_ShouldThrowRuntimeException() throws CsvException {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("INCORRECT_FILE");
			int checkNumberOfRecords = stateCensusAnalyser.readStateData();
		} catch (CsvException e) {
			Assert.assertEquals("Such type file doesn't exist", e.getMessage());
		}
	}

}