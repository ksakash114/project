package com.crmapi.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.crmapi.dto.StudentErrordetails;

@ControllerAdvice
public class GobalExceptionHandler {

	
	@ExceptionHandler(NoValuePresent.class)
	public ResponseEntity<StudentErrordetails> HandleNoValuePresentException(NoValuePresent e,WebRequest request)
	{
	    StudentErrordetails errordetails = new StudentErrordetails(new Date(),e.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StudentErrordetails> HandleallException(Exception e,WebRequest request)
	{
	    StudentErrordetails errordetails = new StudentErrordetails(new Date(),e.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}
}
