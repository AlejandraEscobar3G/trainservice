package com.trainservice.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TrainNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(TrainNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "T404");
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
}
