package com.socialmedia.mysocialmediaapp.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.mysocialmediaapp.entities.HelloWorldBean;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/plain")
	public String getStringMessage() {
		return messageSource.getMessage("hello.world.message",
				null, "Oops!!! Hello World", LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/bean")
	public HelloWorldBean getBeanMessage() {
		return new HelloWorldBean(7, getStringMessage(), new Date());
	}
}
