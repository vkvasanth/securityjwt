package com.example.restdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.models.Address;
import com.example.restdemo.models.Customer;
import com.example.restdemo.models.CustomerDTO;
import com.example.restdemo.models.ErrorClazz;
import com.example.restdemo.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	 CustomerService customerService;
	@PostMapping("/insert")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer customer)
	{
		try
		{
		
		customerService.saveCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e)
		{
			ErrorClazz error= new ErrorClazz(500,e.getMessage());
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.ACCEPTED.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/delete/{email}")
	public void deleteCustomer(@PathVariable String email)
	{
	 customerService.deleteCustomer(email);;
	}
	@GetMapping("/showAll")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomer();
		
	}
	@PutMapping("/update")
	public void updateCustomer(@RequestBody Customer customer)
	{
		customerService.updateCustomer(customer);
	}
	
	@GetMapping("/getcustomer")
	public ResponseEntity<?> getCustomer(@RequestParam (name ="email") String email)
	{
		try {
		System.out.println("Email "+ email);
		CustomerDTO customer =customerService.getCustomer(email);
		return new ResponseEntity<CustomerDTO>(customer,HttpStatus.OK);
		} catch(Exception e)
		{
			ErrorClazz error= new ErrorClazz(500,e.getMessage());
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	

}
