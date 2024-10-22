package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list =  new ArrayList<>();
//		
//		list.add(new Course(1L, "Java Course", "Java Full stack with Expert"));
//		list.add(new Course(2L, "Angular", "Angular Framwork"));
//		list.add(new Course(3L, "React", "React Framwork"));
	}
	
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
//		return list;
	}


	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		
//		for(Course course : list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
//		return c;
		return courseDao.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id " + courseId));

	}


	@Override
	public Course createCourse(Course course) {
//		list.add(course);
//		return course;
		return courseDao.save(course);
	}


	@Override
	public void deleteCourse(Long courseId) throws CourseNotFoundException {
//		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
//		courseDao.deleteById(courseId);
		
		 Optional<Course> course = courseDao.findById(courseId);
		    if (course.isPresent()) {
		        courseDao.deleteById(courseId);
		    } else {
		        throw new CourseNotFoundException(courseId);
		    }
		
	}


	@Override
	public Course updateCourse(Course course) {
//	list.forEach(e ->{
//		if(e.getId() == course.getId()) {
//			  	e.setTitle(course.getTitle());
//			  	e.setDescription(course.getDescription());
//			  	
//		}
//	});
//		return course;
		
		return courseDao.save(course);
	}


	

}
