package com.socialmedia.mysocialmediaapp.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalUserRestExceptionHandler {

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
}
