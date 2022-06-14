package com.cursoSB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoSB.entities.Order;
import com.cursoSB.repository.OrderRepositoty;

@Service 
public class OrderServices {
	


	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE ORDERREPOSITORY;
	private OrderRepositoty repositoty;
	
	public List<Order> findAll(){
		return repositoty.findAll();
	}
	
	public Order findById(Long id) {
		 Optional<Order> obj = repositoty.findById(id);
		 return obj.get();
		 
	}
}
