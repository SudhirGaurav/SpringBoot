package com.sudhir.jpa.hibernate.jpa_and_hibenate.entity;


import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "description")
	private String description ;

	public Review() {
		super();
	}

	
	public Review(Long id, String rating, String description) {
		super();
		this.id = id;
		this.rating = rating;
		this.description = description;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}


	
	
	
	
}
