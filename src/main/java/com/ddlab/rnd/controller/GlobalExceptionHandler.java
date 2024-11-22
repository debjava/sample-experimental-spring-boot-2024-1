package com.ddlab.rnd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ddlab.rnd.exception.AppError;
import com.ddlab.rnd.exception.BadRequestException;
import com.ddlab.rnd.exception.NoSuchEmployeeException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<AppError> handleBadRequest(RuntimeException re) {
		System.out.println("What is the details : "+re.getMessage());
		AppError appError = new AppError(re.getMessage(), "Provide proper valid id", "HttpStatus.BAD_REQUEST.name()");
		return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchEmployeeException.class)
	public ResponseEntity<AppError> handleNoTFound(NoSuchEmployeeException re) {
		System.out.println("What is the details : "+re.getMessage());
		AppError appError = new AppError(re.getMessage(), "Provide proper valid id", HttpStatus.NOT_FOUND.name());
		return new ResponseEntity<>(appError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<AppError> handleGeneralError(RuntimeException re) {
		System.out.println("What is the details : "+re.getMessage());
		AppError appError = new AppError(re.getMessage(), "Highly Unexpected Exception", HttpStatus.INTERNAL_SERVER_ERROR.name());
		return new ResponseEntity<>(appError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
