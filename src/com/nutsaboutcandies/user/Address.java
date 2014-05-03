package com.nutsaboutcandies.user;

public class Address {
	private String unitNumber;
	private String street;
	private String barangay;
	private String city;
	
	public Address(String unitNumber, String street, String barangay, String city) {
		this.unitNumber = unitNumber;
		this.street = street;
		this.barangay = barangay;
		this.city = city;
	}
	
	public Address() {
		
	}
	
	public String getUnitNumber() {
		return unitNumber;
	}
	public String getStreet() {
		return street;
	}
	public String getBarangay() {
		return barangay;
	}
	public String getCity() {
		return city;
	}
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return unitNumber+", "+street+", "+barangay+", "+city;
	}
	
	
}
