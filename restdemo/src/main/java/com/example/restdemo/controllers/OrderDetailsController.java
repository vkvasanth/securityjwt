package com.example.restdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restdemo.models.CustomerDTO;
import com.example.restdemo.models.ErrorClazz;
import com.example.restdemo.models.OrderDetails;
import com.example.restdemo.services.CustomerService;
import com.example.restdemo.services.OrderDetailsService;

@Controller
@RequestMapping("/Order")
public class OrderDetailsController {
	@Autowired
	private OrderDetailsService orderService;
	@PostMapping("/purchase")
	public ResponseEntity<?> saveOrderDetails(@RequestBody OrderDetails order)
	{
		try {
			orderService.saveOrderDetails(order);
			return new ResponseEntity<OrderDetails>(order,HttpStatus.OK);
		}
		catch(Exception e)
		{
		ErrorClazz error=new ErrorClazz(500,e.getMessage());
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	
	}
	@GetMapping("/purchasedetails/{orderid}")
	public ResponseEntity<?> getOrderDetails(@PathVariable int orderid)
	{
		try 
		{
		OrderDetails orderdetails =	orderService.getOrderDetails(orderid);
			if (orderdetails ==null)
			return new ResponseEntity<String>("Order does not exist",HttpStatus.OK);
			return new ResponseEntity<OrderDetails>(orderdetails,HttpStatus.OK);
			}catch(Exception e)
		{
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
