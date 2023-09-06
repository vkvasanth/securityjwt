package com.jpademo.jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressid;
	private String streetno;
	private String city;
	private String country;
	public Address()
	{
		
	}
	public Address( String streetno, String city, String country) {
		super();
		
		this.streetno = streetno;
		this.city = city;
		this.country = country;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getStreetno() {
		return streetno;
	}
	public void setStreetno(String streetno) {
		this.streetno = streetno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", streetno=" + streetno + ", city=" + city + ", country=" + country
				+ "]";
	}
	

}
