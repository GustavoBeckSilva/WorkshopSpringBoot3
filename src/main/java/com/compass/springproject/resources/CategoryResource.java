package com.compass.springproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.springproject.entities.Category;
import com.compass.springproject.entities.Order;
import com.compass.springproject.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = categoryService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // Indica que a requisição aceita um id dentro da URL
	public ResponseEntity<Category> findById(@PathVariable Long id){ // Marcação usada para indicar que o parâmetro veio por URL
		Category category = categoryService.FindById(id);
		return ResponseEntity.ok().body(category);
	}
	
}
