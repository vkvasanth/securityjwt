package com.jpademo.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="productdetails")
public class Product {
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String productname;
	private double price;
	private int quantity ;
	public Product()
	{
		
	}

		public Product(String productname, double price, int quantity) {
		super();
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
	}
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
	

}
