package com.bridgelabz.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
	@CsvBindByName
    private Integer SrNo;
    @CsvBindByName	
	private String StateName;
    @CsvBindByName
	private String TIN;
    @CsvBindByName
	private String StateCode;

	public CSVStates() {
	}

	public Integer getSrNo() {
		return SrNo;
	}

	public void setSrNo(int srNo) {
		SrNo = srNo;
	}

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public String getTIN() {
		return TIN;
	}

	public void setTIN(String TIN) {
		this.TIN = TIN;
	}

	public String getStateCode() {
		return StateCode;
	}

	public void setStateCode(String stateCode) {
		StateCode = stateCode;
	}

	public CSVStates(int srNo, String stateName, String TIN, String stateCode) {
		this.SrNo = srNo;
		this.StateName = stateName;
		this.TIN = TIN;
		this.StateCode = stateCode;
	}
}
