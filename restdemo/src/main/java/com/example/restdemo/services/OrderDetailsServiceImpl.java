package com.example.restdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restdemo.Dao.OrderDetailsDao;
import com.example.restdemo.Dao.ProductDao;
import com.example.restdemo.models.OrderDetails;
import com.example.restdemo.models.OrderItem;
import com.example.restdemo.models.Product;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	OrderDetailsDao orderDetailsDao;
	@Autowired
	ProductDao productDao;
	public OrderDetails saveOrderDetails(OrderDetails orderDetails) throws Exception 
	{
		double totalPrice=0.0;
		List<OrderItem> orderitem=orderDetails.getOrderItem();
		int availableQuantity;
		Product product;
		for(OrderItem item:orderitem)
		{
			System.out.println(item.getQuantity());
			availableQuantity =item.getProduct().getQuantity();
			if(availableQuantity>=item.getQuantity())
			{
			totalPrice+=item.getProduct().getPrice()*item.getQuantity();
            item.setOrder(orderDetails);
            product=item.getProduct();
            product.setQuantity(availableQuantity-item.getQuantity());
            productDao.save(product);
            }
		else
		{
		throw new Exception("out of Stock");	
		}
		orderDetails.setTotalPrice(totalPrice);
		orderDetailsDao.save(orderDetails);
		
		}
		return orderDetails;
	}
	@Override
	public OrderDetails getOrderDetails(int orderid) {
		// TODO Auto-generated method stub
		Optional<OrderDetails> op=orderDetailsDao.findById(orderid);
		if(op.isPresent()) {
			return op.get();
		}else {
		return	null;
		}
		
	}
}
