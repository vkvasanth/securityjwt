package com.example.restdemo.services;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.example.restdemo.models.Customer;
import com.example.restdemo.models.CustomerDTO;
@Service
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {

	@Override
	public CustomerDTO apply(Customer t) {
		// TODO Auto-generated method stub
		return new CustomerDTO(t.getEmail(),t.getFirstname(),t.getPhno(),
				t.getAddress().getSteetname(),t.getAddress().getCity(),
				t.getAddress().getState(),t.getAddress().getPincode());
	}

}
