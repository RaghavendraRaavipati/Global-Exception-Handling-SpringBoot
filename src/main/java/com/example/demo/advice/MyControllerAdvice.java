package com.example.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.custom.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String>handleEmptyInput(EmptyInputException emptyInputException)
	{
		if(emptyInputException.getErrorCode() == "601" || emptyInputException.getErrorCode() == "603" || emptyInputException.getErrorCode() == "606")
		{
			return new ResponseEntity<String>("Input field is empty",HttpStatus.BAD_REQUEST);
		}
		else if(emptyInputException.getErrorCode() == "604" || emptyInputException.getErrorCode() == "605")
		{
			return new ResponseEntity<String>("List is empty",HttpStatus.BAD_REQUEST);
		}
		else if(emptyInputException.getErrorCode() == "607" || emptyInputException.getErrorCode() == "608" || emptyInputException.getErrorCode() == "609")
		{
			return new ResponseEntity<String>("For given id, no record found",HttpStatus.BAD_REQUEST);
		}
		else
			return null;
	}

}
