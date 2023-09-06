package com.example.restdemo.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private Date Purchasedate;
	@ManyToOne
	private Customer customer;
	private double totalPrice;
	@OneToMany(mappedBy="order",
			cascade = CascadeType.ALL)
	private List<OrderItem> orderItem;
	public OrderDetails()
	{
		
	}
	public OrderDetails( Date purchasedate, Customer customer, double totalPrice, List<OrderItem> orderItem) {
		super();
		
		Purchasedate = purchasedate;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.orderItem = orderItem;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getPurchasedate() {
		return Purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		Purchasedate = purchasedate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", Purchasedate=" + Purchasedate + ", customer=" + customer
				+ ", totalPrice=" + totalPrice + ", orderItem=" + orderItem + "]";
	}
	

}
