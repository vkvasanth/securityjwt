package com.example.restdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address_11")
public class Address {
	@Id
	private int id;
	private String steetname;
	private String city;
	private String state;
	private  int pincode;
	public Address()
	{
		
	}
	
	public Address(int id, String steetname, String city, String state, int pincode) {
		super();
		this.id = id;
		this.steetname = steetname;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSteetname() {
		return steetname;
	}
	public void setSteetname(String steetname) {
		this.steetname = steetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", steetname=" + steetname + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	

}
