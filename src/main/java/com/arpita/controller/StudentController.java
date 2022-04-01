package com.arpita.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arpita.entity.Student;
import com.arpita.exceptions.StudentNotFoundException;
import com.arpita.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentrepo;
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	//Save the record
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		Student savedStudent= studentrepo.saveStudent(student);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStudent)
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	//Save the record
	@PostMapping("/students")
	public ResponseEntity<Void> saveAllStudents(@RequestBody List<Student> students) {
		List<Student> savedStudents= studentrepo.saveAllStudents(students);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStudents)
				.toUri();
		return ResponseEntity.created(location).build();
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
//	@ResponseStatus(value=HttpStatus.NOT_FOUND,
//            reason="id not found")  // 409
//	@ExceptionHandler(StudentNotFoundException.class)
	@GetMapping(value= "/students/{id}")
	public Optional<Student> getStudenById(@PathVariable Long id) {
		Optional<Student> student=studentrepo.getStudentById(id);
		logger.debug("Student fetched : "+student.toString());
		if(student.isEmpty()) 
			throw new StudentNotFoundException("id- "+id);
		return student;			
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
	
	
	 @DeleteMapping("students/{id}") 
	 public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) { 
		 studentrepo.deleteStudentById(id);
		 return ResponseEntity.noContent().build(); 
	 }
	 
	 
	 
}
