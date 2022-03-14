package com.arpita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.arpita.entity.Course;
import com.arpita.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
	
	public List<Course> printByTitle(){
		Pageable firstPage=PageRequest.of(0, 10);
		List<Course> courses=courseRepository.findByTitleContaining("J", firstPage);
		return courses;
	}
	
	public void saveCourseWithStudentAndTeacher() {
//		Course course =Course
	}
}
