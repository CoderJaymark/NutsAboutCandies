package com.nuts.about.candies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.nuts.about.candies.model.Ingredient;
import com.nuts.about.candies.model.Product;

public class InventoryDao {
	
	private Connection connection = Dao.getConnection();
	private PreparedStatement preparedStatement;
	private String query;
	
	public InventoryDao() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addProduct(Product product) {
		addIngredient(product.getItems());
		
	}
	
	private void addIngredient(List<Ingredient> items) {
		query = "INSERT INTO ingredients (name, category_id) VALUES (?, ?)";
		int itemCategory = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			for(Ingredient i:items) {
				itemCategory = (i.getCategory().equals("Nuts"))?1:2;
				preparedStatement.setString(1, i.getName());
				preparedStatement.setInt(2, itemCategory);
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
