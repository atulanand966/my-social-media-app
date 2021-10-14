package com.socialmedia.mysocialmediaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.mysocialmediaapp.entities.User;

@Repository
public interface UserJpaDAO extends JpaRepository<User, Integer>{

}
