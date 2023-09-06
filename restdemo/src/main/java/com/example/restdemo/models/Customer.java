package com.example.restdemo.models;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="customer_11")
public class Customer {
	@Id
	private String email;
	private String firstname;
	private String lastname;
	@Column(unique=true,nullable=false)
	private int phno;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressid")
	
	private Address address;
	public Customer()
	{
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Customer(String email, String firstname, String lastname, int phno, String password, Address address) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phno = phno;
		this.password = password;
		this.address = address;
	}
	public Customer(String email, String firstname, String lastname, int phno, Address address) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phno = phno;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", phno=" + phno
			+ ", password=" + password + ", address=" + address + "]";
	
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, email, firstname, lastname, password, phno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(password, other.password) && phno == other.phno;
	}
	
	
}
