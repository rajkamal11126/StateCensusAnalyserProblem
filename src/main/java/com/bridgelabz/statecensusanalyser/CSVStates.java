package com.bridgelabz.statecensusanalyser;

public class CSVStates {
	private String SrNo;
	private String StateName;
	private String TIN;
	private String StateCode;

	public CSVStates() {
	}

	public String getSrNo() {
		return SrNo;
	}

	public void setSrNo(String srNo) {
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

	public CSVStates(String srNo, String stateName, String TIN, String stateCode) {
		this.SrNo = srNo;
		this.StateName = stateName;
		this.TIN = TIN;
		this.StateCode = stateCode;
	}
}
