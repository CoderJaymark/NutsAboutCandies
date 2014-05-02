package com.nutsaboutcandies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.nutsaboutcandies.model.Ingredient;
import com.nutsaboutcandies.model.Product;

public class InventoryDao {
	
	private Connection connection = Dao.getConnection();
	private PreparedStatement preparedStatement;
	private String query;
	
	public InventoryDao() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addProduct(Product product) {
		
		query = "INSERT INTO products (name, type_id, category_id, price, size_id, "
				+ "shelf_life, weight) VALUES(?, ?, ?, ?, ?, ?, ?)";
		int type_id = (product.getType().equals("Regular")?1:2);
		int category_id = product.getCategory().equals("All About Nuts")?1:product.getCategory().equals("All About Candies")?2:3;
		int size_id = product.getSize().equals("Small")?1:product.getSize().equals("Medium")?2:3;
		
		try {
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, type_id);
			preparedStatement.setInt(3, category_id);
			preparedStatement.setBigDecimal(4, product.getPrice());
			preparedStatement.setInt(5, size_id);
			preparedStatement.setInt(6, product.getShelfLife());
			preparedStatement.setInt(7, product.getWeight());
			preparedStatement.executeUpdate();
			connection.commit();
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if(generatedKeys != null && generatedKeys.next()) {
				addIngredient(product.getItems(), generatedKeys.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addIngredient(List<Ingredient> items, int product_id) {
		query = "INSERT INTO ingredients (name, category_id, product_id) VALUES (?, ?, ?)";
		int itemCategory = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			for(Ingredient i:items) {
				itemCategory = (i.getCategory().equals("Nuts"))?1:2;
				preparedStatement.setString(1, i.getName());
				preparedStatement.setInt(2, itemCategory);
				preparedStatement.setInt(3, product_id);
				preparedStatement.executeUpdate();
				connection.commit();
			}
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void addProduct(String name, String size, String category,
			String type, List<Ingredient> ingredients) {
		query = "INSERT INTO user VALUES (?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(0, "Jaymark");
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void removeProduct(int id) {
		
	}
	
	public void updateProduct(int id, Product product) {
		
	}
	
	public List<Product> retrieveProducts() {
		return null;
	}
}
