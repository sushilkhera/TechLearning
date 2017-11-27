package com.sushil.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushil.springboot.beans.Course;
import com.sushil.springboot.repo.CourseServiceRepo;
import com.sushil.springboot.service.CourseService;

@Service(value="courseImpl")
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseServiceRepo courseServiceRepo;
	
	public Course getCourse (long courseId) {
		System.out.println("Service Layer::courseId="+courseId);
		Course dbCourse = (Course)courseServiceRepo.findByCourseId(courseId);
		if(dbCourse!=null) {
			System.out.println("dbCourse::"+dbCourse.toString());
			return dbCourse;
		}else {
			return null;
		}
	}

	@Override
	public void addCourse(Course course) {
		System.out.println("Service Layer::"+course.toString());
		courseServiceRepo.save(course);
	}

	@Override
	public void updateCourse(Course course) {
		courseServiceRepo.save(course);
	}

	@Override
	public void deleteCourse(long courseId) {
		courseServiceRepo.delete(courseId);
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> coursesList = new ArrayList<Course>();
		Iterable<Course> courses= courseServiceRepo.findAll();
		courses.forEach(course -> {
			coursesList.add(course);
		});
		System.out.println("coursesList.size()="+coursesList.size());
		return coursesList;
	}
}
