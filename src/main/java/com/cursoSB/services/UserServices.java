 package com.cursoSB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cursoSB.entities.User;
import com.cursoSB.repository.UserRepositoty;
import com.cursoSB.resources.exceptions.DatabaseException;
import com.cursoSB.services.exceptions.ResourceNotFoundException;

@Service 
public class UserServices {
	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE USERREPOSITORY;
	private UserRepositoty repositoty;
	
	public List<User> findAll(){
		return repositoty.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repositoty.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repositoty.save(obj);
	}
	
	 public void delete(Long id) {
		try {
			repositoty.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	 }
	 
	 public User upDate(Long id, User obj) {
		 User entity = repositoty.getOne(id);
		 upDate(entity, obj);
		 return repositoty.save(entity);
	 }

	private void upDate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
		
}


