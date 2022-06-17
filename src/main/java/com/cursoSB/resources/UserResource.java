package com.cursoSB.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cursoSB.entities.User;
import com.cursoSB.services.UserServices;

// ******CONTROLADOR REST*******
@RestController
@RequestMapping("/users")
public class UserResource {
//ResponseEntity = RETORNA A RESPOSTA DE UMA REQUISIÇÃO WEB;

	@Autowired
	private UserServices service;

	@GetMapping // ENDPOINTs FAZ BUSCAS
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}") // ENDPOINTs RECUPERA DADOS DO BD;
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	// @RequestBody: pega o objeto completo, ele pega o Json do carro e converte
	// para um objeto desde que eles tenham os mesmos atributos;
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<User> upDate(@PathVariable Long id, @RequestBody User obj ){
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
