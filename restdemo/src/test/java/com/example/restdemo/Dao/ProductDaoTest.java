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

import com.example.restdemo.models.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2)
@SpringBootTest
class ProductDaoTest {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private ProductDao productDao;
	@Test
	@Transactional
	
	public void testFindByName() {
		Product product = new Product("iphone",126,3);
		entityManager.persist(product);
		entityManager.flush();
		
		Product findProduct=productDao.findByName("iphone");
		assertNotNull(findProduct);
		assertEquals("iphone",findProduct.getName());
	}
	@Test
	@Transactional
	public void testfindPriceByName()
	{
		Product product = new Product("iphone",126,3);
		entityManager.persist(product);
		entityManager.flush();

		 Optional<Integer> p= productDao.findPriceByName("iphone");
		assertEquals(p.get(),126,"price is"+p);
	}

}
