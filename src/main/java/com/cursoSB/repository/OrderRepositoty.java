package com.cursoSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoSB.entities.Order;

public interface OrderRepositoty extends JpaRepository<Order, Long> {

}
