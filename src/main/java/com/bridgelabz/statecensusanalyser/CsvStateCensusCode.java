package com.bridgelabz.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCensusCode {
	@CsvBindByName
	private Integer srNo;
	@CsvBindByName
	private String stateName;
	@CsvBindByName
	private String TIN;
	@CsvBindByName
	private String stateCode;
	@CsvBindByName
	private String state;
	@CsvBindByName
	private Double population;
	@CsvBindByName
	private Double areaInSqKm;
	@CsvBindByName
	private Double densityPerSqKm;

	public CsvStateCensusCode() {
	}

	public CsvStateCensusCode(Integer srNo, String stateName, String TIN, String stateCode, String state,
			Double population, Double areaInSqKm, Double densityPerSqKm) {
		this.srNo = srNo;
		this.stateName = stateName;
		this.TIN = TIN;
		this.stateCode = stateCode;
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getTIN() {
		return TIN;
	}

	public void setTIN(String TIN) {
		this.TIN = TIN;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
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
		return "CsvStateCensusCode{" + "srNo=" + srNo + ", stateName='" + stateName + '\'' + ", TIN='" + TIN + '\''
				+ ", stateCode='" + stateCode + '\'' + ", state='" + state + '\'' + ", population=" + population
				+ ", areaInSqKm=" + areaInSqKm + ", densityPerSqKm=" + densityPerSqKm + '}';
	}
}
