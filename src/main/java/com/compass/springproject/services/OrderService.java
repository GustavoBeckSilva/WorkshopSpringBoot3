package com.compass.springproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.springproject.entities.Order;
import com.compass.springproject.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order FindById(Long id) {
		
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
		
	}
	
}
