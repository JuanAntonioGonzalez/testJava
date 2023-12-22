package com.mx.walmart.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.walmart.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
