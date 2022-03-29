package com.trainservice.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainservice.java.constants.ApiConstants;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TrainNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(TrainNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ApiConstants.TRAIN_NOT_FOUND);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> exceptionHandler(MethodArgumentNotValidException ex) {
		ValidationErrorResponse errorResponse = new ValidationErrorResponse("Invalid arguments passed", ApiConstants.INVALID_ARGS);
		
		ex.getBindingResult().getFieldErrors().stream().forEach(error -> {
			errorResponse.getInvalidArguments().put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<ValidationErrorResponse>(errorResponse, HttpStatus.OK);
	}
}
