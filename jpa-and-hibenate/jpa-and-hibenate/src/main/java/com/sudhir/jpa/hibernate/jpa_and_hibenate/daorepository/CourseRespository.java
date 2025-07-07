package com.sudhir.jpa.hibernate.jpa_and_hibenate.daorepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudhir.jpa.hibernate.jpa_and_hibenate.entity.Course;

import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;

@Repository
public class CourseRespository {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	public Course getCourseByID(Long id) {
		logger.info(" indide repo getuser by id: "+id);
		Course reference = em.getReference(Course.class, id);
		return reference;
	}

	/*
	 * if id is null --> add entry
	 * if id is not null  --> update the course
	 */
	@Transactional
	public String createOrUpdateCourse(Course course) {
		if(course.getId()==null) {
			// create
			logger.info("Create user: "+course);
			em.persist(course);
			return course.toString()+ " got created";
		}else {
			//update
			logger.info("update user: "+course);
			em.merge(course);
			return course.toString()+ " got updated";
		}
	}
	
	@Transactional
	public  Course deleteCourse(Long id) {
		Course course = getCourseByID(id);
		if(course!=null) {
			em.remove(course);

		}
		return course;
	}

	public List<Course> getAllCourse() {
		//This query is called JPQL query .
		// JPQL -- > That query which talks to the Entity, is called JPQL
		List<Course> courses =em.createQuery("select c from Course c").getResultList();
		return courses;
	}
	
}
