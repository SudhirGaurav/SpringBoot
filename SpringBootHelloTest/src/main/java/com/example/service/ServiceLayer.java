package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BankRepository;
import com.example.model.User;

@Service
public class ServiceLayer {

	//Video-8
	@Autowired
	private BankRepository repository;

	public Collection<User> getAllUser() {

		List<User> users = new ArrayList<User>();
		for (User user : repository.findAll()) {
			users.add(user);
		}
		return users;

	}

	public void delteUser(int id) {
		repository.delete(id);
		
	}
	
	public User getUserByName(String uName) {
		User user = repository.getUserByName(uName);
		User userPh = repository.getUser13213131ByphNumber("8884308945");
		System.out.println("Uset frpm ph is:"+userPh);
		return user;
	}

	public User loginUser(User user) {
		System.out.println("Inside Servuce "+user.getName()+" password --> "+user.getPassword());
		return repository.loginUser(user.getName(), user.getPassword());
		//return null;
	}
}
