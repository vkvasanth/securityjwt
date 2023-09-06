package com.jpaPractice.booksmodels;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusRoute {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busno;
	private String street;
	private String city;
	public int getBusno() {
		return busno;
	}
	public void setBusno(int busno) {
		this.busno = busno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public BusRoute()
	{
		
	}
	public BusRoute(int busno, String street, String city) {
		super();
		this.busno = busno;
		this.street = street;
		this.city = city;
	}
	@Override
	public String toString() {
		return "BusRoute [busno=" + busno + ", street=" + street + ", city=" + city + "]";
	}
	

}
