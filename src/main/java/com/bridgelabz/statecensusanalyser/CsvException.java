package com.bridgelabz.statecensusanalyser;

public class CsvException extends Exception {
	enum ExceptionType {
		FILE_NOT_FOUND, BINDING_PROBLEM_AT_RUNTIME, NULL_DATA_FOUND
	}

	ExceptionType type;

	public CsvException(String message) {
		super(message);
	}

	public CsvException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}

	public CsvException(ExceptionType type, String message, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
