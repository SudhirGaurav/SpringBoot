package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.User;

//video-8
public interface BankRepository extends CrudRepository<User, Integer> {
	

}
