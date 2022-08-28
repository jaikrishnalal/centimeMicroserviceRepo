package com.personal.application.swaggermicroservice.exception;

public class InvalidJsonException extends RuntimeException{

	public InvalidJsonException(String exceptionString) {
		super(exceptionString);
	}
	
}
 