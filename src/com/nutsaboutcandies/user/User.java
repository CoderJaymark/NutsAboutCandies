package com.nutsaboutcandies.user;

import java.sql.Timestamp;
import java.util.Date;

public class User {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String contactNumber;
	private Address address;
	private Timestamp registrationTime;
	private Timestamp lastAccessTime;
	private int roleId;

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

	public Timestamp getRegistrationTime() {
		return registrationTime;
	}

	public Timestamp getLastAccessTime() {
		return lastAccessTime;
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
	
	public void setRegistrationTime() {
		this.registrationTime = new Timestamp(new Date().getTime());
	}
	
	public void setLastAccessTime() {
		this.lastAccessTime = new Timestamp(new Date().getTime());
	}
	
	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}
	
	public void setLastAccessTime(Timestamp lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
