package com.jpaPractice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpaPractice.booksmodels.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class BookDaoImpl {
	@PersistenceContext
	private EntityManager em;
	public  int saveBook(Book book)
	{
		em.persist(book);
		return book.getBookid();
	}
	public  Book getBook(int Bookid)
	{
		Book book=em.find(Book.class,Bookid);
		return book;
	}
	public List<Book> getAllBooks()
	{
		
		Query query =em.createQuery("from Book");
		List<Book> Books=query.getResultList();
		
		return Books;
		
	}
	public Book updateBookprice(int Bookid,int updateBookprice)
	{
		Book book=em.find(Book.class, Bookid);
		book.setBookbrand(updateBookprice);
		em.merge(book);
		
		return book;
		
	}
	public void deleteBook(int Bookid)
	{
		Book book=em.find(Book.class,Bookid);
		em.remove(book);
	}
	
	

}
