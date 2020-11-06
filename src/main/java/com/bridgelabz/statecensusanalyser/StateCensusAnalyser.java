package com.bridgelabz.statecensusanalyser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	private String CSV_FILE_PATH;
    private static String SAMPLE_JSON_FILE_PATH = "/StateCensusAnalyser/src/main/resources/CSVStatesCensusJsonFile.json";
private static String POPULATION_JSON_FILE_PATH="/StateCensusAnalyser/src/main/resources/Population.json";
    public StateCensusAnalyser(String CSV_FILE_PATH) {
        this.CSV_FILE_PATH = CSV_FILE_PATH;
    }

    CSVStatesCensus csvStatesCensus = new CSVStatesCensus();
    CSVStates csvStates = new CSVStates();

    public <E> int readStateData(Class<E> eClass) throws CensusCsvException {
        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))) {
            CsvToBean<E> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(eClass)
                    .build();
            Iterator stateIterator = csvToBean.iterator();
            List<CSVStatesCensus> statesCensusList = new ArrayList<>();
            while (stateIterator.hasNext()) {
                CSVStatesCensus csv = (CSVStatesCensus) stateIterator.next();
                statesCensusList.add(csv);
                count++;
                if (csv instanceof CSVStatesCensus) {
                    if (((CSVStatesCensus) csv).getState() == null || ((CSVStatesCensus) csv).getAreaInSqKm() == null || ((CSVStatesCensus) csv).getDensityPerSqKm() == null || ((CSVStatesCensus) csv).getPopulation() == null) {
                        throw new CensusCsvException("Exception due to Header or mismatch data", CensusCsvException.ExceptionType.NO_SUCH_HEADER);
                    }
                }
            }
            stateAlphabeticalOrder((List<CSVStatesCensus>) statesCensusList);
            mostPopulatedState((List<CSVStatesCensus>) statesCensusList);
        } catch (NoSuchFileException e) {
            if (CSV_FILE_PATH.contains(".csv")) {
                throw new CensusCsvException("Please enter proper file name", CensusCsvException.ExceptionType.NO_SUCH_FILE);
            }
        } catch (RuntimeException e) {
            throw new CensusCsvException("Exception due to incorrect delimiter position", CensusCsvException.ExceptionType.NO_SUCH_FIELD);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void stateAlphabeticalOrder(List<CSVStatesCensus> statesCensusList) throws IOException {
        Comparator<CSVStatesCensus> c = (s1, s2) -> s1.getState().compareTo(s2.getState());
        statesCensusList.sort(c);
        System.out.println(statesCensusList);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(statesCensusList);
        FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
    }

    public void mostPopulatedState(List<CSVStatesCensus> statesCensusList) throws IOException {
        Comparator<CSVStatesCensus> c = (s1, s2) -> Integer.parseInt(s2.getPopulation().trim()) - Integer.parseInt(s1.getPopulation().trim());
        statesCensusList.sort(c);
        System.out.println(statesCensusList);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(statesCensusList);
        FileWriter writer = new FileWriter(POPULATION_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
    }

}
