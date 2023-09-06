package com.example.securitydemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitydemo.models.ErrorClazz;
import com.example.securitydemo.models.User;
import com.example.securitydemo.models.UserDetails;
import com.example.securitydemo.services.UserDetailsServices;

@RestController
@RequestMapping("/Admin")
public class UserDetailsController {
	@Autowired
	 UserDetailsServices UDS;
	@PostMapping("/addUserdetail")
	public ResponseEntity<?>saveUserdetails(@RequestBody UserDetails userdetails){

			UDS.saveUserDetails(userdetails);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
	
	}
	

}
