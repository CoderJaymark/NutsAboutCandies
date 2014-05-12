package com.nutsaboutcandies.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

	public boolean addProduct(Product product) {
		if(product == null) {
			System.out.println("qweqweqwe");
			return false;
		}
		query = "INSERT INTO products (name, type_id, category_id, price, size_id, "
				+ "shelf_life, weight, stock, image) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int type_id = 0, category_id = 0, size_id = 0;
		
		try {
			type_id = (product.getType().equals("Regular")?1:2);
			category_id = product.getCategory().equals("All About Nuts")?1:product.getCategory().equals("All About Candies")?2:3;
			size_id = product.getSize().equals("Small")?1:product.getSize().equals("Medium")?2:3;
		} catch (NullPointerException npe) {
			System.out.println("ERERERERER");
			return false;
		}
		
		try {
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, type_id);
			preparedStatement.setInt(3, category_id);
			preparedStatement.setBigDecimal(4, product.getPrice());
			preparedStatement.setInt(5, size_id);
			preparedStatement.setInt(6, product.getShelfLife());
			preparedStatement.setInt(7, product.getWeight());
			preparedStatement.setInt(8, product.getStock());
			preparedStatement.setString(9, product.getImage());
			preparedStatement.executeUpdate();
			connection.commit();
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if(generatedKeys != null && generatedKeys.next()) {
				addIngredient(product.getItems(), generatedKeys.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	private void addIngredient(List<Ingredient> items, int product_id) {
		query = "INSERT INTO ingredients (name, category_id, product_id) VALUES (?, ?, ?)";
		int itemCategory = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			for (Ingredient i : items) {
				itemCategory = (i.getCategory().equals("Nuts")) ? 1 : 2;
				preparedStatement.setString(1, i.getName());
				preparedStatement.setInt(2, itemCategory);
				preparedStatement.setInt(3, product_id);
				preparedStatement.executeUpdate();
				connection.commit();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch(NullPointerException npe) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

	public boolean removeProduct(int id) {
		query = "DELETE FROM products WHERE product_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateProduct(Product product, int product_id) {
		if(product == null) return false;
		query = "UPDATE products SET name = ?, type_id = ?, category_id = ?, price = ?"
				+ ", size_id = ?, shelf_life = ?, weight = ? WHERE product_id = ?";
		int type_id = 0, category_id = 0, size_id = 0;
		
		try {
			type_id = (product.getType().equals("Regular")?1:2);
			category_id = product.getCategory().equals("All About Nuts")?1:product.getCategory().equals("All About Candies")?2:3;
			size_id = product.getSize().equals("Small")?1:product.getSize().equals("Medium")?2:3;
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			return false;
		}
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, type_id);
			preparedStatement.setInt(3, category_id);
			preparedStatement.setBigDecimal(4, product.getPrice());
			preparedStatement.setInt(5, size_id);
			preparedStatement.setInt(6, product.getShelfLife());
			preparedStatement.setInt(7, product.getWeight());
			preparedStatement.setInt(8, product_id);
			preparedStatement.executeUpdate();
			connection.commit();
			updateIngredients(product.getItems(), product_id);
		} catch (SQLException e) {
			System.out.println("as");
			e.printStackTrace();
			return false;
		} catch (NullPointerException npe) {
			System.out.println("as1");
			npe.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private boolean updateIngredients(List<Ingredient> items, int product_id) {
		query = "UPDATE ingredients SET name = ?, category_id = ? WHERE ingredient_id = ?";
		
		int itemCategory = 0;
		int[] ingredientIds;
		int counter = 0;
		try {
			preparedStatement = connection.prepareStatement("SELECT ingredient_id FROM ingredients WHERE product_id = ?");
			preparedStatement.setInt(1, product_id);
			ResultSet result = preparedStatement.executeQuery();
			result.last();
			ingredientIds = new int[result.getRow()];
			result.beforeFirst();
			while(result.next()) {
				ingredientIds[counter++] = result.getInt(1);
			}
			preparedStatement = connection.prepareStatement(query);
			counter = 0;
			for (Ingredient i : items) {
				
				itemCategory = (i.getCategory().equals("Nuts")) ? 1 : 2;
				preparedStatement.setString(1, i.getName());
				preparedStatement.setInt(2, itemCategory);
				preparedStatement.setInt(3, ingredientIds[counter]);
				preparedStatement.executeUpdate();
				connection.commit();
				counter += 1;
			}

		} catch (SQLException e1) {
			System.out.println("as2");
			e1.printStackTrace();
			return false;
		} catch(NullPointerException npe) {
			System.out.println("as3");
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public List<Product> retrieveProducts() {
		query = "SELECT * FROM products";
		List<Product> products = new ArrayList<Product>();
		Product product;
		String type, size;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				product = new Product();
				product.setItems(retrieveIngredient(result.getInt(1)));
				type = result.getInt(3) == 1?"Regular":"Premium";
				size = result.getInt(6) == 1?"Small":result.getInt(6) == 2?"Medium":"Large";
				product.setName(result.getString(2));
				product.setType(type);
				product.setSize(size);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return products;
	}
	
	private List<Ingredient> retrieveIngredient(int product_id) {
		List<Ingredient> items = new ArrayList<Ingredient>();
		Ingredient item;
		ResultSet result;
		String category;
		query = "SELECT * FROM ingredients WHERE product_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, product_id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				item = new Ingredient();
				item.setName(result.getString(2));
				category = result.getInt(3)==1?"Nuts":"Candies";
				item.setCategory(category);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return items;
	}
	
	public boolean updateStock(int product_id, int stock) {
		query = "UPDATE products SET stock = ? WHERE product_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, stock);
			preparedStatement.setInt(2, product_id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
