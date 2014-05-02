package com.nuts.about.candies;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.nuts.about.candies.dao.InventoryDao;
import com.nuts.about.candies.model.Ingredient;
import com.nuts.about.candies.model.Product;

public class Tester {
	public static void main(String[] args) {
		Product product = new Product();
		product.setName("Prin Cess");
		product.setType("Premium");
		product.setSize("Small");
		
		
		List<Ingredient> items = new ArrayList<Ingredient>();
		Ingredient item = new Ingredient();
		item.setName("Me");
		item.setCategory("Candies");
		items.add(item);
		
		item = new Ingredient();
		item.setName("You");
		item.setCategory("Candies");
		items.add(item);
		
		item = new Ingredient();
		item.setName("Mee");
		item.setCategory("Candies");
		items.add(item);
		
		item = new Ingredient();
		item.setName("Youu");
		item.setCategory("Candies");
		items.add(item);
		
		product.setItems(items);
		
		System.out.println(product.getItems().get(0).getCategory());
		System.out.println(product.getCategory());
		System.out.println(product.getShelfLife());
		System.out.println(product.getType());
		System.out.println(product.getPrice());
		new InventoryDao().addProduct(product);
	}

}
