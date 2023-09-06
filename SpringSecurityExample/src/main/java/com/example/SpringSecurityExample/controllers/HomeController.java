package com.example.SpringSecurityExample.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/public/home")
	public ResponseEntity<?> homeController(){
		return new ResponseEntity<String>("Hello",HttpStatus.OK);
		
	}
	@GetMapping("/public/contactUs")
	public ResponseEntity<?> contactUs(){
		return new ResponseEntity<String>("Contact us with me",HttpStatus.OK);
		
	}
	@GetMapping("/addproduct")
	public ResponseEntity<?> Addproduct(){
		return new ResponseEntity<String>("added get successful",HttpStatus.OK);
		
	}

}
