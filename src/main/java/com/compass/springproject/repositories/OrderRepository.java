package com.compass.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compass.springproject.entities.Order;


// Herda a marcação @Repository do JpaRepository
public interface OrderRepository extends JpaRepository<Order, Long>{}
