package com.socialmedia.mysocialmediaapp.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.mysocialmediaapp.entities.HelloWorldBean;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@GetMapping("/plain")
	public String getStringMessage() {
		return "Hello World. We are learning RESTful web services with Spring Boot and\n"
				+ "using Git as the version control tool";
	}
	
	@GetMapping("/bean")
	public HelloWorldBean getBeanMessage() {
		return new HelloWorldBean(7, getStringMessage(), new Date());
	}
}
