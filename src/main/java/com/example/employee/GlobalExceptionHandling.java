package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(value=AgeException.class)
	public ResponseEntity<Object> ageExceptionhadling(AgeException ae)
	{
		return new ResponseEntity<>(ae.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(value=NameException.class)
	public ResponseEntity<Object>NameExceptionHandling (NameException ne)
	{
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(value=SalaryException.class)
	public ResponseEntity<Object> ExceptionbySalary(SalaryException se)
	{
		return new ResponseEntity<> ("enter within 30000",HttpStatus.BAD_REQUEST);
	}
}
