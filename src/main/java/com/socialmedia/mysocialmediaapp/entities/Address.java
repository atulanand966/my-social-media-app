package com.socialmedia.mysocialmediaapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String suite;
	private String city;
	
	@Pattern(regexp = "^[0-9]{6}$", message = "Invalid Postal Code")
	private String zipcode;
	
	@JsonIgnore
	@OneToOne(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private GeographicalCoordinates geo;
	
	public Address() {
	}

	public Address(String street, String suite, String city, String zipcode) {
		
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	public GeographicalCoordinates getGeo() {
		return geo;
	}

	public void setGeo(GeographicalCoordinates geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode="
				+ zipcode + "]";
	}

}
