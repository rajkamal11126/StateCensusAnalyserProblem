package com.bridgelabz.statecensusanalysertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.statecensusanalyser.CensusCsvException;
import com.bridgelabz.statecensusanalyser.CsvException;
import com.bridgelabz.statecensusanalyser.StateCensusAnalyser;

public class StateCensusAnalyserTest {
	private String STATE_CODE_CSV_FILE = "/StateCensusAnalyser/src/main/resources/IndiaStateCode.csv";
	private String WRONG_STATE_CODE_CSV_FILE = "/StateCensusAnalyser/src/main/resources/IndiaStateCode12.csv";
	private String INCORRECT_FILE = "/StateCensusAnalyser/gradlew.bat";

	@Test
    public void checkToEnsure_NumberOfRecordsMatches() throws CensusCsvException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("STATE_CODE_CSV_FILE");
        Assert.assertEquals(37, stateCensusAnalyser.readStateData());
    }

    @Test
    public void givenWrongFileName_ShouldThrowNoSuchFileException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("WRONG_STATE_CODE_CSV_FILE");
        try {
            int value = stateCensusAnalyser.readStateData();
            Assert.assertEquals(37, value);

        } catch (CensusCsvException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals("Please enter proper file name", e.getMessage());
        }
    }

    @Test
    public void givenWrongFilePath_ShouldThrowRunTimeException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("INCORRECT_FILE");
            int checkNumberOfRecords = stateCensusAnalyser.readStateData();
        } catch (CensusCsvException e) {
            e.printStackTrace();
            Assert.assertEquals("binding of file to failed", e.getMessage());
        }
    }

    @Test
    public void givenMethod_ifFoundIncorrectDelimiterPosition_ShouldReturnException() throws IOException, CensusCsvException {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("STATE_CODE_CSV_FILE");
            int value = stateCensusAnalyser.readStateData();
            Assert.assertEquals(37, value);
        } catch (CensusCsvException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals("Exception due to incorrect delimiter position", e.getMessage());
        }
    }

    @Test
    public void givenMethod_ifFoundNoHeader_ShouldReturnException()
    {

        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("STATE_CODE_CSV_FILE");
            int value = stateCensusAnalyser.readStateData();
            Assert.assertEquals(37, value);
        }
        catch (CensusCsvException e)
        {
            System.out.println(e.getMessage());
            Assert.assertEquals("Exception due to Header", e.getMessage());
        }

    }

}