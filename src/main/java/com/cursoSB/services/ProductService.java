package com.cursoSB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoSB.entities.Product;
import com.cursoSB.repository.ProductRepository;
@Service
public class ProductService {

	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE ProductREPOSITORY;
	private ProductRepository repositoty;
	
	public List<Product> findAll(){
		return repositoty.findAll();
	}
	
	public Product findById(Long id) {
		 Optional<Product> obj = repositoty.findById(id);
		 return obj.get();
		 
	}
}
