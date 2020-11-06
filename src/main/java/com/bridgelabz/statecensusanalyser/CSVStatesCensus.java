package com.bridgelabz.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStatesCensus {
	public CSVStatesCensus() {
	}

	@CsvBindByName
	private String state;

	@CsvBindByName
	private Double population;

	@CsvBindByName
	private Double areaInSqKm;

	@CsvBindByName
	private Double densityPerSqKm;

	public CSVStatesCensus(String state, Double population, Double areaInSqKm, Double densityPerSqKm) {
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getPopulation() {
		return population;
	}

	public void setPopulation(Double population) {
		this.population = population;
	}

	public Double getAreaInSqKm() {
		return areaInSqKm;
	}

	public void setAreaInSqKm(Double areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}

	public Double getDensityPerSqKm() {
		return densityPerSqKm;
	}

	public void setDensityPerSqKm(Double densityPerSqKm) {
		this.densityPerSqKm = densityPerSqKm;
	}

	@Override
	public String toString() {
		return "CSVStateCensus{" + "state='" + state + '\'' + ", population=" + population + ", areaInSqKm="
				+ areaInSqKm + ", densityPerSqKm=" + densityPerSqKm + '}';
	}
}
