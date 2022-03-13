package com.arpita.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class CourseMaterial {
	@Id
	@SequenceGenerator(
			name="course_material_sequence",
			sequenceName="course_material_sequence",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
					generator = "course_material_sequence")
	private Long courseMaterialId;
	private String url;
//	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY,
			optional=false)
	@JoinColumn(
			name="course_id",
			referencedColumnName="courseId")
	private Course course;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public CourseMaterial() {
	}
	public CourseMaterial(String url) {
		this.url = url;
	}
	public Long getCourseMaterialId() {
		return courseMaterialId;
	}
	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
