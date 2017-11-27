package com.sushil.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sushil.springboot.beans.Course;
import com.sushil.springboot.service.CourseService;
/**
 * 
 * @author sushilkhera
 *
 */
@RestController
@RequestMapping("courses")
public class CourseController {
	@Autowired
	@Qualifier("courseImpl")
	CourseService courseService;
	
	////http://localhost:8081/TechLearningApp/courses/1
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("id") long courseId) {
		printMessage("Rest Controller Course id::"+courseId);
		return courseService.getCourse(courseId);
	}
	
	//http://localhost:8081/TechLearningApp/courses/add
	
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course) {
		printMessage("Inside addCourse()");
		printMessage("Received course for add::"+course.toString());
		courseService.addCourse(course);
	}
	
	//http://localhost:8081/TechLearningApp/courses/all
	
	@RequestMapping(path="/all",method=RequestMethod.GET)
	public List<Course> getAllCourses(){
		printMessage("Inside getAllCourses()");
		return courseService.getAllCourses();
	}
	
	//http://localhost:8081/TechLearningApp/courses/update/1
	
	@RequestMapping(path="/update/{id}",method=RequestMethod.PUT)
	public void updateCourse(@PathVariable("id") long courseId,@RequestBody Course course) {
		printMessage("Inside updateCourse()");
		course.setCourseId(courseId);
		printMessage("Received course for update::"+course.toString());
		courseService.updateCourse(course);
	}
	
	//http://localhost:8081/TechLearningApp/courses/delete/1
	
	@RequestMapping(path="/delete/{id}",method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") long courseId) {
		printMessage("Inside deleteCourse()");
		printMessage("Received courseId for delete::"+courseId);
		courseService.deleteCourse(courseId);
	}
	
	public void printMessage(String mgs) {
		System.out.println(mgs);
	}
}
