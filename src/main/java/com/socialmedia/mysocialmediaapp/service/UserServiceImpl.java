package com.socialmedia.mysocialmediaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.mysocialmediaapp.dao.UserDAO;
import com.socialmedia.mysocialmediaapp.entities.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> findAll() {
		
		return userDAO.findAll();
	}

}
