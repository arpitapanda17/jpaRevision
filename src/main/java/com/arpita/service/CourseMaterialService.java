package com.arpita.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpita.entity.CourseMaterial;
import com.arpita.repository.CourseMaterialRepository;

@Service
public class CourseMaterialService {
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	public void saveCourseMaterial(CourseMaterial courseMaterial) {
		courseMaterialRepository.save(courseMaterial);
	}
	
	public List<CourseMaterial> getCourseMaterials() {
		return courseMaterialRepository.findAll();
	}
}	
