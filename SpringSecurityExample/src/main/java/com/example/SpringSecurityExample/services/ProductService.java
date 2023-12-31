package com.example.SpringSecurityExample.services;

import java.util.List;



import com.example.SpringSecurityExample.model.Product;


public interface ProductService {

	List<Product> getAllProducts();

	Product getProduct(int id);

	Product getProductByName(String name);

	Product saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int id);

//	Product getProductByPrice(int price);
	
}
