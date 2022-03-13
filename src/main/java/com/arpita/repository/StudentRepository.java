package com.arpita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arpita.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String str);
	
	public List<Student> findByLastNameNotNull();
	
	public List<Student> findByGuardianName(String firstName);
	
	public List<Student> findByFirstNameAndLastName(String firstName,String lastName);
	
	//Using JPQL get Student
	@Query("Select s from Student s where s.emailId=?1")
	public Student getStudentByEmailAddress(String emailId);
	
	//Using JPQL get Student's first name
	@Query("Select s.firstName from Student s where s.emailId=?1")
	public String getStudentFirstNameByEmailAddress(String emailId);
	
	//Native query
	@Query(value="Select * from tbl_studnent s where s.email_address=?1",
			nativeQuery = true)
	public Student getStudentByEmailNative(String emailId);
	
	//Native query with Named Param
	@Query(value="Select * from tbl_studnent s where s.email_address= :emailId",
			nativeQuery = true)
	public Student getStudentByEmailNativeNamedParam(@Param("emailId") String emailId);
	
}
