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
		
		Optional<User> user = userRepository.findById(id); // Vai no banco de dados e retorna o objeto
		return user.get();
		
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		
		User entity = userRepository.getReferenceById(id); // Prepara o objeto monitorado para ser manipulado
		updateData(entity, obj);
		
		return userRepository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
}
