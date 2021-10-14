package com.socialmedia.mysocialmediaapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Size(min = 5, message = "The username must have atleast 5 characters")
	@Size(max = 20, message = "The username cannot have more than 20 characters.")
	private String username;
	
	@Email
	private String email;
	
	@Pattern(regexp = "\\+[0-9]{2,3}[0-9]{10}", message = "Invalid phone number. Please check again.")
	private String phone;
	
	@Pattern(regexp = "www\\.[a-z]+\\.[a-z]+", message = "Not a valid website")
	private String website;

	public User() {
	}

	public User(int id, String name, String username, String email, String phone, String website) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", phone=" + phone
				+ ", website=" + website + "]";
	}

}
