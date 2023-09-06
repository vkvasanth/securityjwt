package com.example.securitydemo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private int phoneno;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToOne(cascade = CascadeType.ALL)
	private  User User;
	public UserDetails(int id, String firstname, String lastname, int phoneno, Address address, User User) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneno = phoneno;
		this.address = address;
		this.User = User;
	}
	public UserDetails() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		this.User = user;
	}
	@Override
	public String toString() {
		return "UserdDetails [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", phoneno=" + phoneno
				+ ", address=" + address + ", User=" + User + "]";
	}
	

}
