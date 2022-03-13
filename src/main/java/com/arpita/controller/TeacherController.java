package com.arpita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arpita.entity.Teacher;
import com.arpita.service.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;

	@PostMapping("teacher")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}
}
