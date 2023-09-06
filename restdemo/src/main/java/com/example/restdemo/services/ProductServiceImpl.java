package com.example.restdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.restdemo.Dao.ProductDao;
import com.example.restdemo.models.Product;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	 @Autowired
		ProductDao productDao; 
	
	 @Autowired
	
	 public ProductServiceImpl(ProductDao productDao)
	 {
		 super();
		 this.productDao=productDao;
	 }
	 /*
		public ProductServiceImpl(ProductDao productDaomock) {
		// TODO Auto-generated constructor stub
	}
	*/
		public List<Product> getAllProducts()
		{
			return productDao.findAll();
			
}
		@Override
		public Product getProduct(int id) {
			// TODO Auto-generated method stub
			Optional<Product> op=productDao.findById(id);
			if(op.isPresent())
			return op.get();
			else
				return null;
		}
		
		@Override
		public Product getProductByName(String name) {
			// TODO Auto-generated method stub
			return productDao.findByName(name);
			}
		@Override
		public Product saveProduct(Product product) {
			return productDao.save(product);
			
		}
		
		@Override
		public void deleteProduct(int id) {
			// TODO Auto-generated method stub
		   productDao.deleteById(id);
			
		}
		
		@Override
		public void updateProduct(Product product) {
			// TODO Auto-generated method stub
			productDao.save(product);
			
		}
		@Override
		public Product getProductByPrice(int price) {
			// TODO Auto-generated method stub
     		return  productDao.findByPrice(price);
		}
		public Optional<Integer> FindPriceByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}
		
//		public Optional<Integer> FindPriceByName(String price) {
//			// TODO Auto-generated method stub
//			return productDao.findPriceByName(price);
//		}
//		@Override
//		public Product getProductByPrice(int price) {
//			// TODO Auto-generated method stub
//			return productDao.findPriceByName(price);
//		}
		
		
		
}
