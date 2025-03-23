package com.compass.springproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.springproject.entities.User;
import com.compass.springproject.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User FindById(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		return user.get();
		
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
}
