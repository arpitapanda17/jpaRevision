package com.arpita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpita.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
