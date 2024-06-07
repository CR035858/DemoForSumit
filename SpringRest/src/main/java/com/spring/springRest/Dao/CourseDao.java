package com.spring.springRest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springRest.entities.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {
	
}
