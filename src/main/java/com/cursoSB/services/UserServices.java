 package com.cursoSB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoSB.entities.User;
import com.cursoSB.repository.UserRepositoty;

@Service 
public class UserServices {
	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE USERREPOSITORY;
	private UserRepositoty repositoty;
	
	public List<User> findAll(){
		return repositoty.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repositoty.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repositoty.save(obj);
	}
	
	/* public void delete(Long id) {
		repositoty.deleteById(id);
	}*/
		
}


