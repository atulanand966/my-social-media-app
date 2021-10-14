package com.socialmedia.mysocialmediaapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.mysocialmediaapp.dao.UserJpaDAO;
import com.socialmedia.mysocialmediaapp.entities.User;
import com.socialmedia.mysocialmediaapp.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/api/jpa")
public class UserJPARestController {

	@Autowired
	private UserJpaDAO userJpaDAO;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userJpaDAO.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findOne(@PathVariable int id) {
		
		User user = null;
		Optional<User> optionalUser = userJpaDAO.findById(id);
		if(optionalUser.isPresent()) {
			user = optionalUser.get();
		}
		else {
			throw new UserNotFoundException("User with id:"+id+" not found");
		}
		return user;
	}
}
