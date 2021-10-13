package com.socialmedia.mysocialmediaapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalUserRestExceptionHandler
				extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public UserRestExceptionResponse handleUserNotFoundException(UserNotFoundException ex) {
		
		UserRestExceptionResponse response = new UserRestExceptionResponse();
		response.setTimestamp(System.currentTimeMillis());
		response.setMessage(ex.getMessage());
		response.setDetails(null);
		
		return response;
	}
	
	@ExceptionHandler
	public UserRestExceptionResponse handleAllExceptions(Exception ex) {
		UserRestExceptionResponse response = new UserRestExceptionResponse();
		response.setTimestamp(System.currentTimeMillis());
		response.setMessage(ex.getMessage());
		response.setDetails(null);
		
		return response;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		UserRestExceptionResponse response = new UserRestExceptionResponse();
		response.setTimestamp(System.currentTimeMillis());
		response.setMessage(ex.getMessage());
		response.setDetails(request.getDescription(false));
		return new ResponseEntity<Object>(response, status);
	}
	
	
}
