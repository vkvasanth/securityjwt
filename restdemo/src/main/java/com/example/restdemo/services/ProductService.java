package com.example.restdemo.services;

import java.util.List;

import com.example.restdemo.models.Product;

public interface ProductService {
	

	List<Product> getAllProducts();

	Product getProduct(int id);

	Product getProductByName(String name);

    Product saveProduct(Product product);

    void deleteProduct(int id);

	void updateProduct(Product product);

	Product getProductByPrice(int price);

	

}
