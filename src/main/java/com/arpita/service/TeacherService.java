package com.arpita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpita.entity.Teacher;
import com.arpita.repository.TeacherRepository;
@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	public Teacher saveTeacher(Teacher teacher) {
		System.out.println(teacher.getCourses().toString());
		return teacherRepository.save(teacher);
	}
}
