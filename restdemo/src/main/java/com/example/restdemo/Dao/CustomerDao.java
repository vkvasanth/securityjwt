package com.example.restdemo.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restdemo.models.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	void deleteByEmail(String email);

	Customer findByEmail(String email);
	
	Optional<Customer> findByEmailAndPassword(String email, String password);

	
}
