package com.compass.springproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.springproject.entities.Product;
import com.compass.springproject.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product FindById(Long id) {
		
		Optional<Product> product = productRepository.findById(id);
		return product.get();
		
	}
	
}
