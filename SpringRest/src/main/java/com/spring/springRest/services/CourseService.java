package com.spring.springRest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springRest.entities.Course;

@Service
public interface CourseService {
	
	public List<Course> getCourses();
	
	public Course getCourse(int courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(int courseId);
	
}
