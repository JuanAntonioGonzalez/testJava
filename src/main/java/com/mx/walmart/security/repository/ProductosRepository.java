package com.mx.walmart.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.walmart.security.model.Productos;


public interface ProductosRepository extends JpaRepository<Productos, Long> {
	
}
