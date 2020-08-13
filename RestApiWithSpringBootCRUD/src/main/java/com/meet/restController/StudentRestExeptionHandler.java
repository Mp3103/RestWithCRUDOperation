package com.meet.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.meet.entity.CustomError;
import com.meet.exeptionHandler.StudentNotFoudExeption;

/*
 * This Class is Created for handle Exeption
 * */

@ControllerAdvice
public class StudentRestExeptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<CustomError> handleExeption(StudentNotFoudExeption studentExeption){
		
		CustomError error = new CustomError(HttpStatus.NOT_FOUND.value(), 
				studentExeption.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<CustomError>(error , HttpStatus.NOT_FOUND);
		
	}
	

	@ExceptionHandler
	public ResponseEntity<CustomError> handleExeption(Exception exeption){
		
		CustomError error = new CustomError(HttpStatus.BAD_REQUEST.value(), 
				exeption.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<CustomError>(error , HttpStatus.NOT_FOUND);
		
	}
	
}
