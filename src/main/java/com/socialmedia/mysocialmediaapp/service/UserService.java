package com.socialmedia.mysocialmediaapp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.socialmedia.mysocialmediaapp.entities.User;

@Component
public interface UserService {

	List<User> findAll();

	User findOne(int id);

	User save(User user);
}
