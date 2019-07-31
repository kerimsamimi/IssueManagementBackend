package com.kerimsamimi.issuemanagement.advice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kerimsamimi.issuemanagement.controller.ProjectController;

@ControllerAdvice
@RestController
public class IMExceptionHandler extends ResponseEntityExceptionHandler{
	
	final static Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest request){
		
		logger.error("ControllerAdvice -> ExceptionHandler ->", ex , request);
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),ex.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
	}

}
