package com.arpita.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@SequenceGenerator(
			name="course_sequence",
			sequenceName="course_sequence",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
					generator = "course_sequence")
	
	private Long courseId;
	private String title;
	private Integer credit;
	
//	@JsonBackReference
	@JsonIgnore
	@OneToOne(mappedBy="course")
	private CourseMaterial courseMaterial;
	@Transient
	private String url;
	
	@ManyToMany
	@JoinTable(
			name="student_course_map",
			joinColumns=@JoinColumn(
					name="course_id",
					referencedColumnName="courseId"),
			inverseJoinColumns=@JoinColumn(
					name="student_id",
					referencedColumnName="studentId"))
	private List<Student> students;
	
	public Course() {
		super();
	}
	public Course(String title, Integer credit) {
		this.title = title;
		this.credit = credit;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getUrl() {
		if(getCourseMaterial()!=null)
			return getCourseMaterial().getUrl();
		return this.url;
	}
	public void setUrl(String url) {
		if(getCourseMaterial()!=null)
			getCourseMaterial().setUrl(url);
		this.url =url ;
	}
	public CourseMaterial getCourseMaterial() {
		return courseMaterial;
	}
	public void setCourseMaterial(CourseMaterial courseMaterial) {
		this.courseMaterial = courseMaterial;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudents(Student student) {
		if(students==null) students=new ArrayList<>();
		students.add(student);
	}
}
