package com.socialmedia.mysocialmediaapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.mysocialmediaapp.dao.UserDAO;
import com.socialmedia.mysocialmediaapp.entities.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userDAO.findAll();
	}
}
