package com.example.SpringSecurityExample.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityExample.Dao.CustomerDao;
import com.example.SpringSecurityExample.model.Customer;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerDao customerDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = customerDao.findByEmail(username);
		if(customer==null)
			throw new UsernameNotFoundException("user details aare not found");
		else
		{
			List<GrantedAuthority> authoritie= new LinkedList<GrantedAuthority>();
			authoritie.add(new SimpleGrantedAuthority(customer.getRole()));
			return new User(customer.getEmail(),customer.getPassword(),authoritie);
			
		}
		
		
	}
	public Customer registerCustomer(Customer customer)
	{
		return customerDao.save(customer);
		
	}
}
