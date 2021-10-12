package com.socialmedia.mysocialmediaapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@GetMapping("/plain")
	public String getStringMessage() {
		return "Hello World. We arer learning RESTful web services with Spring Boot and\n"
				+ "using Git as the version control tool";
	}
}
