package com.cursoSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoSB.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
