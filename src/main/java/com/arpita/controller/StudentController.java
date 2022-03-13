package com.arpita.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arpita.entity.Student;
import com.arpita.service.StudentRepositoryTest;

@RestController
public class StudentController {

	@Autowired
	private StudentRepositoryTest studentrepo;
	
	//Save the record
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student) {
		return studentrepo.saveStudent(student);
	}
	
	//Get all student records
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentrepo.getAllStudents();
	}
	
	@GetMapping("/students/filter")
	public List<Student> getStudentsByFirstName(@RequestParam String firstName) {
		return studentrepo.getStudentsByFirstName(firstName);
	}
	
	@GetMapping(value= "/students/{id}")
	public Optional<Student> getStudenById(@PathVariable int id) {
		return studentrepo.getStudentById(id);
	}
	
	@GetMapping(value= "/students/fns")
	public List<Student> getStudentsByNameContaining(@RequestParam String firstNamesub) {
		return studentrepo.getStudentsByFirstNameContaining(firstNamesub);
	}
	
	@GetMapping(value= "/students/lastNameNotNull")
	public List<Student> getStudentsByLastNameNotNull() {
		return studentrepo.getStudentsByLastNameNotNull();
	}
	
	@GetMapping(value= "/students/filterByGuardian")
	public List<Student> getStudentsByGuardianName(@RequestParam String name) {
		return studentrepo.getStudentsByGuardianName(name);
	}
	
	@GetMapping("/students/name")
	public List<Student> getStudentsByName(@RequestParam(name="firstName", defaultValue="")  String firstName, @RequestParam(name="lastName")  String lastName){
		return studentrepo.getStudentByFirstNameAndLastName("Arpita","Panda");
	}
	
	@GetMapping(value= "/students/filterByEmail")
	public Student getStudentsByEmailAddress(@RequestParam String email) {
		return studentrepo.getStudentByEmailAddress(email);
	}
	
	//get student first name by email
	@GetMapping(value= "/students/retrieveFirstName")
	public String getStudentFirstNameByEmailAddress(@RequestParam String email){
		return studentrepo.getStudentFirstNameByEmailAddress(email);
	}
}
