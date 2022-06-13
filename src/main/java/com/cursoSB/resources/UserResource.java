package com.cursoSB.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoSB.entities.User;
import com.cursoSB.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserResource {
//ResponseEntity = RETORNA A RESPOSTA DE UMA REQUISIÇÃO WEB;
	
	@Autowired
	private UserServices service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
	     User obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}
	
	
}
