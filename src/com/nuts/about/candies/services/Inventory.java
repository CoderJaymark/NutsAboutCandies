package com.nuts.about.candies.services;

import java.util.ArrayList;
import java.util.List;

import com.nuts.about.candies.model.Ingredient;
import com.nuts.about.candies.model.Product;

public class Inventory {
	private List<Product> products = new ArrayList<Product>();

	public void addProduct(String name, String size, String category,
			String type, ArrayList<Ingredient> ingredients) {

	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(int id) {
		try {
			products.remove(id);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("Error in removing product. ID : " + id);
		}
	}

	public void updateProduct(int id, String name, String size,
			String category, String type, ArrayList<Ingredient> ingredients) {
		try {
			Product product = products.get(id);
			product.setName(name);
			product.setSize(size);
			product.setType(type);
			product.setItems(ingredients);
			products.set(id, product);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("Error in updating product. ID : " + id);
		}
	}

	public List<Product> getProducts() {
		if (products.isEmpty()) {
			System.out.println("Inventory is empty");
			return null;
		}
		return products;
	}
}
