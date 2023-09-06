package com.example.restdemo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.restdemo.Dao.ProductDao;
import com.example.restdemo.models.Product;

class ProductServiceImplTest {

	@Test
	void testGetProductByName() {
		ProductDao productDaomock=mock(ProductDao.class);
		when(productDaomock.findByName("Notebook")).thenReturn(new Product(1,"notebook",33,5));
		var productServiceImpl=new ProductServiceImpl(productDaomock);
		 
		Product d=productServiceImpl.getProductByName("Notebook");
		assertEquals(d, new Product(1,"notebook",33,5));
	}

	@Test
	void testFindPriceByName() {
	var productDaomock=mock(ProductDao.class);
	when(productDaomock.findPriceByName("Notebook")).thenReturn(Optional.of(33));
	 
	var productServiceImpl=new ProductServiceImpl(productDaomock);
	Optional<Integer> d=productServiceImpl.FindPriceByName("Notebook");
	assertEquals(d,33);
	
	}

}
