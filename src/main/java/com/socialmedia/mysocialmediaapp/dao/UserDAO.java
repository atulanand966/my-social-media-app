package com.socialmedia.mysocialmediaapp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.socialmedia.mysocialmediaapp.entities.User;

@Component
public interface UserDAO {

	List<User> findAll();
}
