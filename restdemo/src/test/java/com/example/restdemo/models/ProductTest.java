package com.example.restdemo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	Product p1=null;
	Product p2=null;
	Product p3=null;
	@BeforeEach
	void setUp()
	{
		p1=new Product(1, "notebook", 10,2);
		p2=new Product(1, "notebook", 10,2);
		p3=new Product(2, "Waterbottle", 12,3);
		System.out.println("before each");
		
	}

	@Test
	void testEqualsObject() {
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(null));
		assertFalse(p1.equals("Hello"));
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));
	}
	@AfterEach
	void tearDown()
	{
		p1=null;
		p2=null;
		p3=null;
		System.out.println("after each");
	}


}
