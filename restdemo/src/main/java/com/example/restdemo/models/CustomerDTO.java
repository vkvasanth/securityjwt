package com.example.restdemo.models;

public class CustomerDTO {
	private String email;
	private String firstname;
	private int phno;
	private String steetname;
	private String city;
	private String state ;
	private int pincode;
	
	
	public CustomerDTO()
	{
		
	}


	public CustomerDTO(String email, String firstname, int phno, String steetname, String city, String state,
			int pincode) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.phno = phno;
		this.steetname = steetname;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
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


	public int getPhno() {
		return phno;
	}


	public void setPhno(int phno) {
		this.phno = phno;
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
		return "CustomerDTO [email=" + email + ", firstname=" + firstname + ", phno=" + phno + ", steetname="
				+ steetname + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

	
	

}
