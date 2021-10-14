package com.socialmedia.mysocialmediaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.mysocialmediaapp.entities.Address;

public interface AddressDAO  extends JpaRepository<Address, Integer>{

}
