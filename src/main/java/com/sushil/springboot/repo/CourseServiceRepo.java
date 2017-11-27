package com.sushil.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.sushil.springboot.beans.Course;
/**
 * 
 * @author sushilkhera
 *
 */
public interface CourseServiceRepo extends CrudRepository<Course, Long>{
	
	public Course findByCourseId(long courseID);
}
