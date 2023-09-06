package com.example.restdemo.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.restdemo.models.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	Product findByName( String name);
   //@Query(value = "SELECT p.price FROM Product p WHERE p.name = ?1")
	//Optional<Integer> findPriceByName(String price);
	//Product findPriceByName(String price);
	//Product findPriceByName(int price);
	//Optional<Integer> findPriceByName(String price);
	Product findByPrice(int price);
	Optional<Integer> findPriceByName(String string);
	



	

}
