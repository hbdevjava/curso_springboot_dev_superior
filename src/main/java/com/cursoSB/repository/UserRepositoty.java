package com.cursoSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoSB.entities.User;

public interface UserRepositoty extends JpaRepository<User, Long> {

}
