package com.cursoSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoSB.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
