package com.bridgelabz.statecensusanalyser;

public class CensusCsvException extends Exception {
	ExceptionType type;

	enum ExceptionType { NULL_DATA_FOUND, NO_SUCH_HEADER, NO_SUCH_FILE, NO_SUCH_FIELD };

	public CensusCsvException(String message, ExceptionType cause) {
		super(message);
	}

	public CensusCsvException(ExceptionType type, String message, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
