package com.example.restdemo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArithmeticExpressionTest {
	ArithmeticExpression arith;
	@BeforeEach
	 void setUp()
	 {
		arith=new ArithmeticExpression();
		System.out.println("Before each");
	 }

	@Test
	void testAdd() {
		int actual = arith.add(2, 3);
		int expected =5;
		assertEquals(expected,actual);
		
	}

	@Test
	void testSub() {
		int actual = arith.sub(4, 5);
		int expected =-1;
		assertEquals(expected,actual);
	}
	@AfterEach
	void tearDown()
	{
		arith=null;
		System.out.println("after each");
	}

}
