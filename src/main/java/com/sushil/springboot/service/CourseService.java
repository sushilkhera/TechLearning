package com.sushil.springboot.service;

import java.util.List;

import com.sushil.springboot.beans.Course;

public interface CourseService {
	
	public Course getCourse(long courseId);
	
	public void addCourse(Course course);
	
	public void updateCourse(Course course);
	
	public void deleteCourse(long course);
	
	public List<Course> getAllCourses();
}
