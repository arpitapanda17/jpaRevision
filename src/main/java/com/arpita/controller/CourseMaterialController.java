package com.arpita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arpita.entity.CourseMaterial;
import com.arpita.service.CourseMaterialService;

@RestController
public class CourseMaterialController {

	@Autowired
	private CourseMaterialService courseMaterialService;
	
	@PostMapping("courseMaterial")
	public void saveCourseMaterial(@RequestBody CourseMaterial courseMaterial) {
		courseMaterialService.saveCourseMaterial(courseMaterial);
	} 
	
	@GetMapping("courseMaterials")
	public List<CourseMaterial> getCourseMaterials() {
		return courseMaterialService.getCourseMaterials();
	} 
	
}
