package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseNotFoundException;
import com.springrest.springrest.services.CourseService;

@CrossOrigin(origins = "http://localhost:3001") 
@RestController
public class MyRestController {

	private CourseService courseService;
	
	public MyRestController(CourseService courseService) {
		
		this.courseService = courseService;
	}

	@GetMapping("/helth")
	public String home() {
		return "MyRestControllerHelth is working";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	
	@PostMapping("/course")
	public Course createCourse(@RequestBody Course course) {
		return this.courseService.createCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable String courseId) {
	    Long id = Long.valueOf(courseId);
	    try {
	        this.courseService.deleteCourse(id);
	        return new ResponseEntity<>("Successfully deleted course with ID: " + courseId, HttpStatus.OK);
	    } catch (CourseNotFoundException e) {
	        return new ResponseEntity<>("Course with ID: " + courseId + " not found", HttpStatus.NOT_FOUND);
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred while deleting course with ID: " + courseId, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
