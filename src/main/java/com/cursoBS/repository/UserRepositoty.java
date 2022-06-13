package com.cursoBS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoBS.entities.User;

public interface UserRepositoty extends JpaRepository<User, Long> {

}
