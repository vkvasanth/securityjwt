package com.example.restdemo.Dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.restdemo.models.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2)
@SpringBootTest
class CustomerDaoTest {
	@PersistenceContext
	 EntityManager entityManager;
	@Autowired
     CustomerDao customerDao;
	@Test
	@Transactional

	void testFindByEmailAndPassword() {
		Customer customer =new Customer("vsnth33@gmail.com","vasanth","kumar",944434,"12345",null);
		entityManager.persist(customer);
		entityManager.flush();
		
		 Optional<Customer> p=  customerDao.findByEmailAndPassword("vsnth33@gmail.com","12345");
		 assertEquals(p.get(), customer);
		
	}
	@Test
	@Transactional
	void testFindByEmailAndPassword1() {
		Customer customer =new Customer("vsnth33@gmail.com","vasanth","kumar",944434,"12345",null);
		entityManager.persist(customer);
		entityManager.flush();
		
		 Optional<Customer> p=  customerDao.findByEmailAndPassword("Aswini22@gmail.com","12345");
		 assertTrue(p.isEmpty());
		
	}


}
