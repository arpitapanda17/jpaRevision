package com.arpita.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpita.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	List<Course> findByTitleContaining(String title,Pageable pageable);
}
