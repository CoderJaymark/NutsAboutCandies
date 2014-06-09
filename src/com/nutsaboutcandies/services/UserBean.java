package com.nutsaboutcandies.services;

import javax.servlet.http.HttpServletRequest;

import com.nutsaboutcandies.user.Address;
import com.nutsaboutcandies.user.User;

public class UserBean {
	public static User createUser(HttpServletRequest req) {
		User user = new User();
		user.setFirstname(req.getParameter("firstname"));
		user.setLastname(req.getParameter("lastname"));
		user.setContactNumber(req.getParameter("contact"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setRoleId(0);
		user.setRegistrationTime();
		user.setLastAccessTime();
		
		Address address = new Address();
		address.setUnitNumber(req.getParameter("unit"));
		address.setStreet(req.getParameter("street"));
		address.setBarangay(req.getParameter("barangay"));
		address.setCity(req.getParameter("city"));
		
		System.out.println(address.getUnitNumber());
		System.out.println(address.getBarangay());
		System.out.println(address.getCity());
		System.out.println(address.getStreet());
		
		user.setAddress(address);
		return user;
	}
}
