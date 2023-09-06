package com.example.restdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restdemo.Dao.CustomerDao;
import com.example.restdemo.models.Customer;
import com.example.restdemo.models.CustomerDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
     CustomerDao customerDao;
	@Autowired
	CustomerDTOMapper mapper;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return customerDao.save(customer);
	}

	@Override
	public void deleteCustomer (String email) {
		// TODO Auto-generated method stub
		customerDao.deleteByEmail(email);
	
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
		
	}

	@Override
	public Customer getByEmail(String email) {
		// TODO Auto-generated method stub
		return customerDao.findByEmail(email);
	}

	@Override
	public CustomerDTO getCustomer(String email) {
		// TODO Auto-generated method stub
		Customer customer =customerDao.findByEmail(email);
		return mapper.apply(customer);
	}

	
	
	
}
