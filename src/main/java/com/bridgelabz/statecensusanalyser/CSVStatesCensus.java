package com.bridgelabz.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStatesCensus {
	@CsvBindByName
	String State;
	@CsvBindByName
	Double Population;
	@CsvBindByName
	Double AreaInSqKm;
	@CsvBindByName
	Double DensityPerSqKm;

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Double getPopulation() {
		return Population;
	}

	public void setPopulation(Double population) {
		Population = population;
	}

	public Double getAreaInSqKm() {
		return AreaInSqKm;
	}

	public void setAreaInSqKm(Double areaInSqKm) {
		AreaInSqKm = areaInSqKm;
	}

	public Double getDensityPerSqKm() {
		return DensityPerSqKm;
	}

	public void setDensityPerSqKm(Double densityPerSqKm) {
		DensityPerSqKm = densityPerSqKm;
	}
}
