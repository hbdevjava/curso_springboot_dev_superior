package com.cursoSB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoSB.entities.Category;
import com.cursoSB.repository.CategoryRepository;
@Service
public class CategoryService {

	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE USERREPOSITORY;
	private CategoryRepository repositoty;
	
	public List<Category> findAll(){
		return repositoty.findAll();
	}
	
	public Category findById(Long id) {
		 Optional<Category> obj = repositoty.findById(id);
		 return obj.get();
		 
	}
}
