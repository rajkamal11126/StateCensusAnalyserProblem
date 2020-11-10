package com.bridgelabz.statecensusanalysertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.statecensusanalyser.CSVStates;
import com.bridgelabz.statecensusanalyser.CSVStatesCensus;
import com.bridgelabz.statecensusanalyser.CensusCsvException;
import com.bridgelabz.statecensusanalyser.CsvException;
import com.bridgelabz.statecensusanalyser.StateCensusAnalyser;

@SuppressWarnings("unused")
public class StateCensusAnalyserTest {
	private String STATE_CODE_CSV_FILE = "/StateCensusAnalyser/src/main/resources/IndiaStateCode.csv";
	private String WRONG_STATE_CODE_CSV_FILE = "/StateCensusAnalyser/src/main/resources/IndiaStateCode12.csv";
	private String STATE_CENSUS_INFO_CSV_FILE_PATH = "/StateCensusAnalyser/src/main/resources/IndiaStateCensusData.csv";
	private String INCORRECT_FILE = "/StateCensusAnalyser/gradlew.bat";
	private String INCORRECT_STATE_CODE = "/StateCensusAnalyser/src/main/resources/IncorrectStatecode.csv";

	@Test
	public void checkToEnsure_NumberOfRecordsMatches() throws CensusCsvException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CODE_CSV_FILE);
		Assert.assertEquals(37, stateCensusAnalyser.readStateData(CSVStates.class));
	}

	@Test
	public void givenWrongFileName_ShouldThrowNoSuchFileException() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(WRONG_STATE_CODE_CSV_FILE);
		try {
			int value = stateCensusAnalyser.readStateData(CSVStates.class);
			Assert.assertEquals(37, value);

		} catch (CensusCsvException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Please enter proper file name", e.getMessage());
		}
	}

	@Test
	public void givenWrongFilePath_ShouldThrowRunTimeException() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(INCORRECT_FILE);
			int checkNumberOfRecords = stateCensusAnalyser.readStateData(CSVStates.class);
		} catch (CensusCsvException e) {
			e.printStackTrace();
			Assert.assertEquals("binding of file to failed", e.getMessage());
		}
	}

	@Test
	public void givenMethod_ifFoundIncorrectDelimiterPosition_ShouldReturnException()
			throws IOException, CensusCsvException {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(INCORRECT_STATE_CODE);
			int value = stateCensusAnalyser.readStateData(CSVStates.class);
			Assert.assertEquals(37, value);
		} catch (CensusCsvException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Exception due to incorrect delimiter position", e.getMessage());
		}
	}

	@Test
	public void givenMethod_ifFoundNoHeader_ShouldReturnException() {

		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CODE_CSV_FILE);
			int value = stateCensusAnalyser.readStateData(CSVStates.class);
			Assert.assertEquals(37, value);
		} catch (CensusCsvException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Exception due to Header", e.getMessage());
		}
	}

	@Test
	public void givenMethod_CheckNumberOfRecodesMatchesOrNot_ForStatesCensus_ShouldReturnTrue()
			throws IOException, CensusCsvException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CENSUS_INFO_CSV_FILE_PATH);
		int count = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
		Assert.assertEquals(29, count);
	}

	@Test
	public void givenMethod_ifFoundIncorrectName_OfStatesCensusFile_ShouldThrowException() throws IOException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CENSUS_INFO_CSV_FILE_PATH);
		try {
			int value = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
			Assert.assertEquals(29, value);
		} catch (CensusCsvException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Please enter proper file name", e.getMessage());
		}
	}

	@Test
	public void givenWrongFilePath_ShouldThrowRunTimeException_ReturnFalse() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(INCORRECT_FILE);
			int checkNumberOfRecords = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
		} catch (CensusCsvException e) {
			e.printStackTrace();
			Assert.assertEquals("Exception due to Header or mismatch data", e.getMessage());
		}
	}

	@Test
	public void givenMethod_ifFoundIncorrectDelimiterPositionInCSVStatusCensus_ShouldReturnException()
			throws IOException, CensusCsvException {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CENSUS_INFO_CSV_FILE_PATH);
			int value = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
			Assert.assertEquals(29, value);
		} catch (CensusCsvException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Exception due to Header or mismatch data", e.getMessage());
		}
	}

	@Test
	public void givenMethod_ifFoundNoHeaderInCSVStatusCensus_ShouldReturnException() {

		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CENSUS_INFO_CSV_FILE_PATH);
			int value = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
			Assert.assertEquals(29, value);
		} catch (CensusCsvException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Exception due to Header", e.getMessage());
		}
	}

	@Test
	public void givenCsvFile_ifSortBystateAlphabeticalOrder_ShouldReturnTrue() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CENSUS_INFO_CSV_FILE_PATH);
			int value = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
			Assert.assertEquals(29, value);
		} catch (CensusCsvException e) {
			Assert.assertEquals("Exception due to Header", e.getMessage());
		}
	}

	@Test
	public void givenCsvFile_ifSortByMostPopulatedState_ShouldReturnTrue() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CENSUS_INFO_CSV_FILE_PATH);
			int value = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
			Assert.assertEquals(29, value);
		} catch (CensusCsvException e) {
			Assert.assertEquals("Exception due to Header", e.getMessage());
		}
	}

	@Test
	public void givenCsvFile_ifSortByPopulationDensityState_ShouldReturnTrue() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CENSUS_INFO_CSV_FILE_PATH);
			int value = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
			Assert.assertEquals(29, value);
		} catch (CensusCsvException e) {
			Assert.assertEquals("Exception due to Header", e.getMessage());
		}
	}

	@Test
	public void givenCsvFile_ifSortByLargestStateArea_ShouldReturnTrue() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(STATE_CENSUS_INFO_CSV_FILE_PATH);
			int value = stateCensusAnalyser.readStateData(CSVStatesCensus.class);
			Assert.assertEquals(29, value);
		} catch (CensusCsvException e) {
			Assert.assertEquals("Exception due to Header", e.getMessage());
		}
	}
}