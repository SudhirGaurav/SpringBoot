package com.sudhir.jpa.hibernate.jpa_and_hibenate.entity;


import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "number")
	private String number ;

	public Passport() {
		super();
	}

	public Passport(Long id, String name) {
		super();
		this.id = id;
		this.number = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setName(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
	
}
