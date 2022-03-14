package com.arpita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpita.entity.Course;
import com.arpita.entity.CourseMaterial;
import com.arpita.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("courses")
	public List<Course> getCourses(){
		return courseService.getCourses();
	}
	
	@GetMapping("coursePagewise")
	public List<Course>  getCoursesPagination() {
		return courseService.printByTitle();
	}
}
