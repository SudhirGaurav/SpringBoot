package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDriverApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("starting spring Boot app Test");
		SpringApplication.run(SpringBootDriverApp.class, args);

	}
}

//SpringBoot+JPA+SpringMVC
// For Referring video : https://www.youtube.com/playlist?list=PLdJYl6XU45uLIHaPBQEj-cEMynAl0oeiz

/*
Rest call API,
1.http://localhost:8080/getUserByName?uName=sudhir
2.http://localhost:8080/getAllUser
3.http://localhost:8080/getAllUser?id=<Profide user id>
 */
