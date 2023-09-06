package com.example.SpringSecurityExample.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurityExample.model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	Customer findByEmail(String email);

}
