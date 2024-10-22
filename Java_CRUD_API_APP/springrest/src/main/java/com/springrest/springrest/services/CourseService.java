package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;


public interface CourseService {

	List<Course> getCourses();

	Course getCourse(long courseId);

	Course createCourse(Course course);

	Course updateCourse(Course course);

	void deleteCourse(Long courseId) throws CourseNotFoundException;

}
