package com.arpita.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arpita.entity.CourseMaterial;
import com.arpita.service.CourseMaterialService;

@RestController
public class CourseMaterialController {

	@Autowired
	private CourseMaterialService courseMaterialService;
	
	@PostMapping("courseMaterial")
	public ResponseEntity<CourseMaterial> saveCourseMaterial(@RequestBody CourseMaterial courseMaterial) {
		CourseMaterial savedCourseMaterial= courseMaterialService.saveCourseMaterial(courseMaterial);
		URI location= ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedCourseMaterial)
						.toUri();
		return ResponseEntity.created(location).build();
	} 
	
	@GetMapping("courseMaterials")
	public List<CourseMaterial> getCourseMaterials() {
		return courseMaterialService.getCourseMaterials();
	} 
	
	@GetMapping("courseMaterialsPagewise")
	public Page<CourseMaterial>  getCourseMaterialsPagination() {
		return courseMaterialService.getCourseMaterialsPagination();
	}
}
