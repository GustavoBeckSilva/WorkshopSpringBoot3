package com.compass.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compass.springproject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{}
