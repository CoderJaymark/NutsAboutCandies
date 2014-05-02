package com.nutsaboutcandies.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error finding driver class");
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nutsaboutcandies", "root", "");
		} catch (SQLException e) {
			System.out.println("Error in connecting to database");
			e.printStackTrace();
		}
		
		if(connection != null) System.out.println("Connection established");
		return connection;
	}
}
