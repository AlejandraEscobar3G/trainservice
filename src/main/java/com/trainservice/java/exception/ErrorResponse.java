package com.trainservice.java.exception;

public class ErrorResponse {

	public String message;
	public String statusCode;
	
	public ErrorResponse(String message, String statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}
