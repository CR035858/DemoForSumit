package com.spring.springRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springRest.Dao.CourseDao;
import com.spring.springRest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao cDao;
	//List<Course> list;
	public CourseServiceImpl() {
//		list =new ArrayList<>();
//		list.add(new Course(145,"Java Core ","this course contains the java develpoment and core modules"));
//		
//		list.add(new Course(129,"python","this course i made for python learners and also"));
//		
	}
	
	@Override
	public List<Course> getCourses(){
		return cDao.findAll();
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(int courseId) {
//		Course c=null;
//		for(Course course1:list) {
//			if(course1.getId() == courseId) {
//				c=course1;
//				break;
//			}
//		}
		return cDao.findById(courseId).get();
		
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
		cDao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
	 cDao.save(course);
	 return course;
	}

	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
//		list= this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
	Course c =  cDao.findById(courseId).get();
		cDao.delete(c);;
	}
	
	
}
