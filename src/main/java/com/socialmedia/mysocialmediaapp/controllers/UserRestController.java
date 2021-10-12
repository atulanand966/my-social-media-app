package com.socialmedia.mysocialmediaapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.socialmedia.mysocialmediaapp.entities.User;
import com.socialmedia.mysocialmediaapp.exceptions.UserNotFoundException;
import com.socialmedia.mysocialmediaapp.exceptions.UserRestExceptionResponse;
import com.socialmedia.mysocialmediaapp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findOne(@PathVariable int id) {
		User user = userService.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("No such user, where id = "+id);
		}
		
		return user;
	}
	
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
