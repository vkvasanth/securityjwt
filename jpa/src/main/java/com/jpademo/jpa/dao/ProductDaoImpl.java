 package com.jpademo.jpa.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpademo.jpa.models.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class ProductDaoImpl {
	@PersistenceContext
	private EntityManager em;
	public int savaProduct(Product product)
	{
		em.persist(product);
		return product.getId();
	}
	
	//
	//find and select
	
	public Product getProduct (int id)
	{
		Product product=em.find(Product.class, id);
		return product;
		
	}
	
	//update
	
	public Product updateProductname (int id,String updatedProductname)
	{
		Product product =em.find(Product.class, id);
		product .setProductname(updatedProductname);
		em.merge(product);
		return product;
		
	}
	//delete
	
	public void deleteProduct(int id)
	{
		Product product =em.find(Product.class, id);
		em.remove(product);
	}
	
	//select *from productdetails
	
	public List<Product> getAllProducts()
	{
		
		Query query=em.createQuery("from Product");
		List<Product> products=query.getResultList();
		return products;
		
	}

}
