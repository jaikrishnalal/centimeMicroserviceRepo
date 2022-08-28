package com.personal.application.swaggermicroservice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ServiceError {
	
	private HttpStatus httpStatus;
	private List<String> errors;
	private LocalDateTime timeStamp;
	private String url;
	
	
	
	public ServiceError(HttpStatus httpStatus, List<String> errors, LocalDateTime timeStamp, String url) {
		super();
		this.httpStatus = httpStatus;
		this.errors = errors;
		this.timeStamp = timeStamp;
		this.url = url;
	}
	
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
