package com.arpita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpita.entity.Student;
import com.arpita.repository.StudentRepository;

//@SpringBootTest - ideally should not be used for testing 
//JPA layer, using here as we are storing the records
//@DataJpaTest -for testing JPA later
//@SpringBootTest
@Service
public class StudentRepositoryTest{
	@Autowired
	private StudentRepository studentRepository;
	
	//Insert or update
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	//get all student details
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	//get student by Id
	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);
	}

	//get student details having the given FirstName
	public List<Student> getStudentsByFirstName(String firstName){
		return studentRepository.findByFirstName(firstName);
	}
	
	//get student details having the given FirstName containing
	public List<Student> getStudentsByFirstNameContaining(String sub){
		return studentRepository.findByFirstNameContaining(sub);
	}
	
	//get student details having the given lastName not null
	public List<Student> getStudentsByLastNameNotNull(){
		return studentRepository.findByLastNameNotNull();
	}
	
	//get student details having the given guardian name 
	public List<Student> getStudentsByGuardianName(String name){
		return studentRepository.findByGuardianName(name);
	}
	
	//get student details having the given first name and last name
	public List<Student> getStudentByFirstNameAndLastName(String firstName,String lastName){
		return studentRepository.findByFirstNameAndLastName(firstName,lastName);
	}
	
	//get student details by email
	public Student getStudentByEmailAddress(String emailId){
		return studentRepository.getStudentByEmailAddress(emailId);
	}
	
	//get student first name by email
	public String getStudentFirstNameByEmailAddress(String emailId){
		return studentRepository.getStudentFirstNameByEmailAddress(emailId);
	}

	
}
