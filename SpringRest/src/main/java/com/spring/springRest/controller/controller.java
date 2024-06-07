package com.spring.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springRest.entities.Course;
import com.spring.springRest.services.CourseService;


@RestController
public class controller {
	
	@Autowired
	public CourseService courseS;
	
	@GetMapping("/home")
	public String home() {
		
		return "welcome to this course";
	}
	
	
	@GetMapping("/course")
	public List<Course> getCourses() {
		return this.courseS.getCourses();		
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		return this.courseS.getCourse(courseId);
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) { 
		return this.courseS.addCourse(course);
	}
	
	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseS.updateCourse(course);
	}
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int courseId){
		try {
			this.courseS.deleteCourse(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	}
}
