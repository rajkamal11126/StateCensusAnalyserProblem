package com.bridgelabz.statecensusanalyser;

public class CsvException extends Exception{
	 enum ExceptionType {FILE_NOT_FOUND,BINDING_PROBLEM_AT_RUNTIME}
	    ExceptionType type;

	    public CsvException(String message) {
	        super(message);
	    }

	    public CsvException(ExceptionType type,String message,Throwable cause) {
	        super(message,cause);
	        this.type=type;
	    }
}
