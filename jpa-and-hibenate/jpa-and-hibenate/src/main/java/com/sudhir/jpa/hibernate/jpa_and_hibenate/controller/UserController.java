package com.sudhir.jpa.hibernate.jpa_and_hibenate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.jpa.hibernate.jpa_and_hibenate.daorepository.CourseRespository;
import com.sudhir.jpa.hibernate.jpa_and_hibenate.dto.CourseDTO;
import com.sudhir.jpa.hibernate.jpa_and_hibenate.entity.Course;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRespository courseRespository;
	
	//CRUD
	@GetMapping("/getuser")
	public String getUser() {
		return "Yes i got the user";
	}
	//@ResponseBody
	@PostMapping(value ="/getuserbyid" , produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseDTO getUser(@RequestBody Long id) {
		logger.info("Inside get user by id : "+id);
		Course course= courseRespository.getCourseByID(id);
		logger.info("course isss : "+course);
		CourseDTO courseDTO = new CourseDTO(course);
		return courseDTO;
	}
	
	@PostMapping(value = "/createorupdatecourse" )
	public String createCourse(@RequestBody CourseDTO courseDTO) {
		
		logger.info(" Create or udate user dto : "+courseDTO.toString());
		Course course= new Course(courseDTO.getId(), courseDTO.getName());
		
		String msg= courseRespository.createOrUpdateCourse(course);
		return msg;
	}
	
	@GetMapping(value = "/deletecourse/{id}")
	public CourseDTO deleteCourse(@PathVariable Long id) {
		
		//return new CourseDTO(courseRespository.deleteCourse(id), "got deelted ");
		
		courseRespository.deleteCourse(id);
		return new CourseDTO(null, "got deelted ");

	}

	@GetMapping(value ="/getallcourse" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CourseDTO> getAllCourse() {
		logger.info("Inside getAllUser");
		//Course course= courseRespository.getAllCourse();
		//logger.info("course isss : "+course);
		List<Course> courses =  courseRespository.getAllCourse();
		logger.info("Inside getAllUser courses size: "+courses.size());
		CourseDTO coursesDTO = new CourseDTO(courses);
		List<CourseDTO> coursesDto=	coursesDTO.getCoursesDto();
		return coursesDto;
	}
}
