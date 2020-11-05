package com.bridgelabz.statecensusanalysertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.statecensusanalyser.StateCensusAnalyser;

public class StateCensusAnalyserTest {
	@Test
	public void checkToEnsure_NumberOfRecordsMatches() throws IOException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Assert.assertEquals(37, stateCensusAnalyser.readStateData());
	}
}
