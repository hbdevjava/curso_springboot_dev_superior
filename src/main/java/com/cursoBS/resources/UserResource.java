package com.cursoBS.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBS.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
//ResponseEntity = RETORNA A RESPOSTA DE UMA REQUISIÇÃO WEB;
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999", "1234");
		return ResponseEntity.ok().body(u);
	}
	
}
