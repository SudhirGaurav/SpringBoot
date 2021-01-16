package com.example.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.User;

//video-8
public interface BankRepository extends CrudRepository<User, Integer> {
	
	
	@Query(  nativeQuery=true,value= "SELECT * FROM User u where u.user_name = :uName") 
	public User getUserByName(@Param("uName") String uName);
	//why used nativeQuery? got to the link --> https://stackoverflow.com/questions/42145271/noviablealtexception-while-using-spring-data-query-with-hibernate

}
