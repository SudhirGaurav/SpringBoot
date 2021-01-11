package com.example.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.ServiceLayer;

@RestController
public class ControllerClass {

	@Autowired
	private ServiceLayer service;
	@GetMapping(value="/") // One default  must be there . Other wise localHost8080 will not open
	public String defaultMethopd() {
		System.out.println("Called default method....");
		return "I am here ";
	}
	
	@GetMapping(value="/getAllUser")
	public Collection<User> getAllUser(){
		Collection<User> users= service.getAllUser();
		System.out.println("Inside get all user."+users);
		return users;

	}
}
