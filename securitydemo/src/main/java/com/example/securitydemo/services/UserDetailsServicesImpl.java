package com.example.securitydemo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securitydemo.dao.UserDetailsDao;
import com.example.securitydemo.models.UserDetails;

import jakarta.transaction.Transactional;
 @Service
 @Transactional
public class UserDetailsServicesImpl implements UserDetailsServices {

	@Autowired
	UserDetailsServices userDetailsServices;
	@Autowired
	UserDetailsDao uDao;
	@Override
	public UserDetails saveUserDetails(UserDetails userdetails) {
		// TODO Auto-generated method stub
		return  uDao.saveUserDetails(userdetails);
	}
	
	

	


}
