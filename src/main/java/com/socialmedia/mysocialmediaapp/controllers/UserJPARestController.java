package com.socialmedia.mysocialmediaapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/users")
	public User save(@RequestBody User user) {
		user.setId(0);
		userJpaDAO.saveAndFlush(user);
		return user;
	}
	
	@PutMapping("/users")
	public User update(@RequestBody User user) {
		
		Optional<User> optionalUser = userJpaDAO.findById(user.getId());
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User with id:"+user.getId()+" not found");
		}
		userJpaDAO.saveAndFlush(user);
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteById(@PathVariable int id) {
		userJpaDAO.deleteById(id);
		return "User deleted successfully.";
	}
}
