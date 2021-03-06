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

	@Override
	public User findOne(int id) {
		
		return userDAO.findOne(id);
	}

	@Override
	public User save(User user) {
		
		return userDAO.save(user);
	}

	@Override
	public User update(User user) {
		
		return userDAO.update(user);
	}

	@Override
	public void delete(int id) {
		
		userDAO.delete(id);
	}

}
