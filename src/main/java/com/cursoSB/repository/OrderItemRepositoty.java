package com.cursoSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoSB.entities.OrderItem;

public interface OrderItemRepositoty extends JpaRepository<OrderItem, Long> {

}
