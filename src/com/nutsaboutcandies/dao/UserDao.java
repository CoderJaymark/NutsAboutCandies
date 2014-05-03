package com.nutsaboutcandies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nutsaboutcandies.user.Address;
import com.nutsaboutcandies.user.User;
import com.nutsaboutcandies.utilities.HashMaker;

public class UserDao {
	private Connection connection = Dao.getConnection();
	PreparedStatement preparedStatement;
	String query;
	public boolean addUser(User user) {
		int address_id = addAddress(user.getAddress());
		query = "INSERT INTO users (firstname, lastname, email, password, contact_number, address_id"
				+ ", role_id, registrationTime, lastAccessTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, HashMaker.makeHash(user.getPassword()));
			preparedStatement.setString(5, user.getContactNumber());
			preparedStatement.setInt(6, address_id);
			preparedStatement.setInt(7, 1);
			preparedStatement.setTimestamp(8, user.getRegistrationTime());
			preparedStatement.setTimestamp(9, user.getLastAccessTime());
			preparedStatement.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private int addAddress(Address address) {
		query = "INSERT INTO address (unit_number, street, barangay, city) VALUES (?, ?, ?, ?)";
		int address_id = 0;
		try {
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, address.getUnitNumber());
			preparedStatement.setString(2, address.getStreet());
			preparedStatement.setString(3, address.getBarangay());
			preparedStatement.setString(4, address.getCity());
			preparedStatement.executeUpdate();
			ResultSet result = preparedStatement.getGeneratedKeys();
			while(result != null && result.next()) {
				address_id = result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address_id;
	}
	
	public boolean removeUser(int user_id) {
		query = "DELETE FROM users WHERE user_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user_id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateUser(User user, int user_id) {
		int address_id = retrieveAddressId(user_id);
		updateAddress(user.getAddress(), address_id);
		query = "UPDATE users SET firstname = ?, lastname = ?, email = ?, "
				+ "password = ?, contact_number = ? WHERE user_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, HashMaker.makeHash(user.getPassword()));
			preparedStatement.setString(5, user.getContactNumber());
			preparedStatement.setInt(6, user_id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private void updateAddress(Address address, int address_id) {
		query = "UPDATE address SET unit_number = ?, street = ?, "
				+ "barangay = ?, city = ? WHERE address_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, address.getUnitNumber());
			preparedStatement.setString(2, address.getStreet());
			preparedStatement.setString(3, address.getBarangay());
			preparedStatement.setString(4, address.getCity());
			preparedStatement.setInt(5, address_id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int retrieveAddressId(int user_id) {
		try {
			preparedStatement = connection.prepareStatement("SELECT address_id FROM users where user_id = ?");
			preparedStatement.setInt(1, user_id);
			ResultSet result = preparedStatement.executeQuery();
			connection.commit();
			while(result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
