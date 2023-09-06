package com.example.restdemo.controllers;
 

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/rest")
public class HelloController {
	public HelloController()
	{
		System.out.println("<<<<<HelloConttroller is instaniate>>>>>");
	}
	//@GetMapping(value="/hello")
	@RequestMapping(method = RequestMethod.GET,value="/hello")
	public String helloWorld()
	{
		
		return "Hello World";
		
	}
	@RequestMapping(method =RequestMethod.GET,value="/data")
	public String someData()
	{
		return "somedata";
		
	}
	
}
