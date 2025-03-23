package com.compass.springproject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// Para recuperar dados, usa-se o get. Para inserir dados, usa-se o post
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){ // A marcação indica que o objeto chega em formato JSON e é desserializado para o objeto User
		
		obj = userService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		// É correto retornar o código 201, indicando a criação de recurso
		return ResponseEntity.created(uri).body(obj);
	}
	
}
