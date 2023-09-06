package com.jpaPractice.booksmodels;

import org.springframework.boot.CommandLineRunner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="BookDetails")

public class Book {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="bid")
	private  int Bookid;
	private String Bookname;
	private int Bookprice;
	
	public Book()
	{
		
	}
	 
	
	public Book( String bookname, int bookprice) {
		super();
		
		Bookname = bookname;
		Bookprice = bookprice;
	}
	public int getBookid() {
		return Bookid;
	}
	public void setBookid(int bookid) {
		Bookid = bookid;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public int getBookprice() {
		return Bookprice;
	}
	public void setBookbrand(int bookprice) {
		Bookprice = bookprice;
	}
	@Override
	public String toString() {
		return "Book [Bookid=" + Bookid + ", Bookname=" + Bookname + ", Bookbrand=" + Bookprice + "]";
	}
	
	

}
