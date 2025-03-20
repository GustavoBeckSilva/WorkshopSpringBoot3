package com.compass.springproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.springproject.entities.Order;
import com.compass.springproject.entities.User;
import com.compass.springproject.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = orderService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // Indica que a requisição aceita um id dentro da URL
	public ResponseEntity<Order> findById(@PathVariable Long id){ // Marcação usada para indicar que o parâmetro veio por URL
		Order order = orderService.FindById(id);
		return ResponseEntity.ok().body(order);
	}
	
}
