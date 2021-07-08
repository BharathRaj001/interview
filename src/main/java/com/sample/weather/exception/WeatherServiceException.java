package com.sample.weather.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class WeatherServiceException extends RuntimeException{

	private static final long serialVersionUIDAdder =1L;
	
	private final String errorType;
	private final String errorCode;
	private final String errorMessage;
	private String responseBody;
	private int statusCode=HttpStatus.BAD_REQUEST.value();

	
	public WeatherServiceException(String errorType, String errorCode, String errorMessage, String responseBody,
			int statusCode) {
		super();
		this.errorType = errorType;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.responseBody = responseBody;
		this.statusCode = statusCode;
	}
	
	public WeatherServiceException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorType=null;
	}

}
