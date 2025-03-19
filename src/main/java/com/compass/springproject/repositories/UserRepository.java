package com.compass.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compass.springproject.entities.User;


// Herda a marcação @Repository do JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{}
