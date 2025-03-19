package com.compass.springproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.springproject.entities.User;
import com.compass.springproject.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = userService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // Indica que a requisição aceita um id dentro da URL
	public ResponseEntity<User> findById(@PathVariable Long id){ // Marcação usada para indicar que o parâmetro veio por URL
		User user = userService.FindById(id);
		return ResponseEntity.ok().body(user);
	}
	
}
