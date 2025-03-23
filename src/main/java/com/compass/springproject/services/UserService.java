package com.compass.springproject.services;

import java.util.List;
import java.util.Optional;
import com.compass.springproject.resources.exceptions.ResourceExceptionHandler;
import com.compass.springproject.services.exceptions.DatabaseException;
import com.compass.springproject.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.compass.springproject.entities.User;
import com.compass.springproject.repositories.UserRepository;

@Service
public class UserService {

    private final ResourceExceptionHandler resourceExceptionHandler;

	@Autowired
	private UserRepository userRepository;

    UserService(ResourceExceptionHandler resourceExceptionHandler) {
        this.resourceExceptionHandler = resourceExceptionHandler;
    }
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User FindById(Long id) {
		
		Optional<User> user = userRepository.findById(id); // Vai no banco de dados e retorna o objeto
		return user.orElseThrow(() -> new ResourceNotFoundException(id)); // Tenta o get, caso não ter sucesso, lança exceção 
		
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());// Lançada exceção personalizada para violação de integridade de dados
		}
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
