package com.socialmedia.mysocialmediaapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.socialmedia.mysocialmediaapp.entities.User;
import com.socialmedia.mysocialmediaapp.exceptions.UserNotFoundException;

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
	public EntityModel<User> findOne(@PathVariable int id) {
		User user = userService.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("No such user, where id = "+id);
		}
		
		EntityModel<User> model = EntityModel.of(user);
		
		WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
		
		model.add(linkToUsers.withRel("all-users"));
		
		return model;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> save(@Valid@RequestBody User user) {

		user.setId(0);
		User savedUser = userService.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/users")
	public User update(@Valid@RequestBody User user) {
		
		User dbUser = userService.findOne(user.getId());
		if(dbUser == null) {
			throw new UserNotFoundException("No such user, where id = "+user.getId());
		}
		
		user = userService.update(user);
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public User delete(@PathVariable int id) {
		User user = userService.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("No such user, where id = "+id);
		}
		
		userService.delete(id);
		
		return user;
	}
	
}
