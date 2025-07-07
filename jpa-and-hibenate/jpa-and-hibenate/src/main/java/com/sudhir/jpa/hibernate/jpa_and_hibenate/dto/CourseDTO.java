package com.sudhir.jpa.hibernate.jpa_and_hibenate.dto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sudhir.jpa.hibernate.jpa_and_hibenate.entity.Course;

public class CourseDTO {

	Long id;
	String name;
	String message;
	List<CourseDTO> coursesDto;
	
	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDTO(Course course ) {

		if(course!=null) {
			this.id = course.getId();
			this.name = course.getName();
		}
		
	}

	public CourseDTO(Course course , String message) {

		if (course != null) {
			this.id = course.getId();
			this.name = course.getName();
		}
		this.message = message;
	}

	public CourseDTO(List<Course> courses) {
		if(courses !=null || !courses.isEmpty()) {
			coursesDto=	courses.stream().map(course -> new CourseDTO(course)).collect(Collectors.toList());
		}
	}

	//Getter must be mentioned becase ,Jackson used public getter method to convert java to JSON
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<CourseDTO> getCoursesDto() {
		return coursesDto;
	}

	public void setCoursesDto(List<CourseDTO> coursesDto) {
		this.coursesDto = coursesDto;
	}
	
	

}
