package com.example.SpringSecurityExample.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurityExample.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
		Product findByName( String name);
	  
}
