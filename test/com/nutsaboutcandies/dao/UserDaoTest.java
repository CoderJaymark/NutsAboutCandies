package com.nutsaboutcandies.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nutsaboutcandies.user.Address;
import com.nutsaboutcandies.user.User;

public class UserDaoTest {
	
	private User user;
	private Address address;
	private UserDao dao = new UserDao();
	@Test
	public void addUserTest() {
		user = new User();
		user.setFirstname("Jay");
		user.setLastname("Mark");
		user.setEmail("jay@nac.com");
		user.setContactNumber("09159736116");
		user.setPassword("123");
		user.setRegistrationTime();
		user.setLastAccessTime();
		
		address = new Address();
		address.setUnitNumber("7812");
		address.setBarangay("Olympia");
		address.setStreet("J.B Roxas");
		address.setCity("Makati City");
		
		user.setAddress(address);
		
//		assertTrue(dao.addUser(user));
		
	}
	
	@Test
	public void updateUserTest() {
		user = new User();
		user.setFirstname("Ja123123y");
		user.setLastname("Mark");
		user.setEmail("jay@1n1ac.com");
		user.setContactNumber("09159736116");
		user.setPassword("123wer");
		
		address = new Address();
		address.setUnitNumber("78123112");
		address.setBarangay("Olympia");
		address.setStreet("J.B Rox1as");
		address.setCity("Makati asd");
		
		user.setAddress(address);
		assertTrue(dao.updateUser(user, 1));
	}
	
	@Test
	public void isUserRegisteredTest() {
		
		assertTrue(dao.isUserRegistered("jay@1n1ac.com"));
	}
}
