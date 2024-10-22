package com.springrest.springrest.services;

public class CourseNotFoundException extends Exception {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseNotFoundException(Long id) {
	        super("Course not found with id: " + id);
	    }

}
