package com.compass.springproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.springproject.entities.Category;
import com.compass.springproject.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category FindById(Long id) {
		
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
		
	}
	
}
