package com.example.restdemo.services;

import com.example.restdemo.models.OrderDetails;

public interface OrderDetailsService {

	//void saveOrderDetails(OrderDetails order);
	OrderDetails saveOrderDetails(OrderDetails orderDetails) throws Exception;

	OrderDetails getOrderDetails(int orderid);

}
