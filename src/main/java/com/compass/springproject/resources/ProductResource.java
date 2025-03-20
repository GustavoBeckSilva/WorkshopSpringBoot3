package com.compass.springproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.springproject.entities.Product;
import com.compass.springproject.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = productService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // Indica que a requisição aceita um id dentro da URL
	public ResponseEntity<Product> findById(@PathVariable Long id){ // Marcação usada para indicar que o parâmetro veio por URL
		Product product = productService.FindById(id);
		return ResponseEntity.ok().body(product);
	}
	
}
