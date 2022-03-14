package com.arpita.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.arpita.entity.CourseMaterial;
import com.arpita.repository.CourseMaterialRepository;

@Service
public class CourseMaterialService {
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial) {
		return courseMaterialRepository.save(courseMaterial);
	}
	
	public List<CourseMaterial> getCourseMaterials() {
		return courseMaterialRepository.findAll();
	}
	
	public Page<CourseMaterial> getCourseMaterialsPagination(){
		Pageable firstPageWithThreeRecords=PageRequest.of(0, 3);//page,size
		Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
		
		Page<CourseMaterial> courseMaterials= courseMaterialRepository.findAll(firstPageWithThreeRecords);
		
		long totalElements=courseMaterialRepository.findAll(firstPageWithThreeRecords).getTotalElements();
		
		int totalPages=courseMaterialRepository.findAll(firstPageWithThreeRecords).getTotalPages();
		
		System.out.println("Total Elements: "+totalElements);
		System.out.println("Total Pages: "+totalPages);
		return courseMaterials;
	}
	
	public void findAllSorting() {
		Pageable sortByTitle=PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
	}
	
	
}	
