package com.example.SpringSecurityExample.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurityExample.model.Customer;
import com.example.SpringSecurityExample.model.LoginCredentials;
import com.example.SpringSecurityExample.services.CustomerUserDetailService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@CrossOrigin("http://localhost:30002")
@RestController
public class CustomerController {
	@Autowired
	CustomerUserDetailService customerUserDetailService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	private SecurityContextRepository securityContextRepository=
			new HttpSessionSecurityContextRepository();
	@PostMapping("/public/register")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer customer){

		String password=customer.getPassword();
		String hashpwd=passwordEncoder.encode(password);
		customer.setPassword(hashpwd);
		customer=customerUserDetailService.registerCustomer(customer);
		customer.setRole("Role_USER");
		try {
			if(customer.getId()>0){
			return new ResponseEntity<String>("Register successful",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("user not registered",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 }catch (Exception e) {
			 return new ResponseEntity<String> (e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	
		
	}
	@PostMapping("/public/Login")
	public ResponseEntity<?> login(@RequestBody LoginCredentials lc, HttpServletRequest request,
			HttpServletResponse response){
		Authentication authentication=authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(lc.getEmail(), lc.getPassword()));
		SecurityContext context=SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authentication);
		securityContextRepository.saveContext(context, request, response);
		//boolean authenticated =authentication.isAuthenticated();
		System.out.println(authentication.getPrincipal());
		if(authentication.isAuthenticated())
		return new ResponseEntity<Object>(authentication.getPrincipal(),HttpStatus.OK);
		else {
			return new ResponseEntity<String>("Invalid credentials",HttpStatus.UNAUTHORIZED);
		}
		
	}
	@GetMapping("/logoutsuccess")
	public ResponseEntity<?> logout (HttpServletRequest request){
		System.out.println("inside logout........");
		HttpSession session=request.getSession();
		session.invalidate();
		Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
		SecurityContextHolder.clearContext();
		authentication.setAuthenticated(false);
		return new ResponseEntity<String>("logout successfull",HttpStatus.OK);
	}
	

}
