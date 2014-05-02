package com.nutsaboutcandies.user;

public class User {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String contactNumber;
	private Address address;
	
	public User() {
		
	}
	
	public User(String firstname, String lastname, String email,
			String password, String contactNumber, Address address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}