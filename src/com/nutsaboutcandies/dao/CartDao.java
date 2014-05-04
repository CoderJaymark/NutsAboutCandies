package com.nutsaboutcandies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nutsaboutcandies.model.Product;
import com.nutsaboutcandies.user.Cart;

public class CartDao {
	private Cart cart = new Cart();
	private Connection connection = Dao.getConnection();
	PreparedStatement preparedStatement;
	String query;
	public void addProduct(Product product) {
		query = "INSERT INTO orders (product_id";
	}
	
	private int getProductId(String name, String size, String type) {
		int size_id = size.equals("Small")?1:size.equals("Medium")?2:3;
		int type_id = type.equals("Regular")?1:2;
		
		query = "SELECT product_id FROM products WHERE name = ?";
		return 0;
	}
}
