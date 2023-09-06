package com.example.restdemo.services;

import java.util.List;

import com.example.restdemo.models.Customer;
import com.example.restdemo.models.CustomerDTO;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	//void deleteByid(int id);

	void deleteCustomer(String email);

	List<Customer> getAllCustomer();

	void updateCustomer(Customer customer);

	Customer getByEmail(String email);

	

	CustomerDTO getCustomer(String email);

	 
		// TODO Auto-generated method stub
		
	

	

	//void deleteCustomer(String email);

	

	

	

}
