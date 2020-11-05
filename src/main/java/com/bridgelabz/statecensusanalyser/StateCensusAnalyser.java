package com.bridgelabz.statecensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	private static final String SAMPLE_CSV_FILE_PATH = "/home/admin265/IdeaProjects/StateCensusAnalyserProblem/src/main/resources/StateCode.csv";

    public int readStateData() {
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBean<CSVStates> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(CSVStates.class)
                    .build();
            System.out.println(csvToBean.toString());
            Iterator<CSVStates> stateIterator = csvToBean.iterator();

            while (stateIterator.hasNext()) {
                CSVStates state = stateIterator.next();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
