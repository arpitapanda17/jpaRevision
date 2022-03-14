package com.arpita.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arpita.entity.Teacher;
import com.arpita.service.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;

	@PostMapping("teacher")
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
		Teacher savedTeacher= teacherService.saveTeacher(teacher);
		URI location=ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedTeacher)
						.toUri();
		return ResponseEntity.created(location).build();
	}
}
