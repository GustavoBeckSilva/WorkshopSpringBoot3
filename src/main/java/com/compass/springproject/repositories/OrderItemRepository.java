package com.compass.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compass.springproject.entities.OrderItem;
import com.compass.springproject.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{}
