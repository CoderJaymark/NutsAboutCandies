package com.nuts.about.candies.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nuts.about.candies.model.Ingredient;
import com.nuts.about.candies.model.Product;

public class ProductCreator {
	public static Product createProduct(HttpServletRequest r) {
		Product product = new Product();
		Ingredient item = new Ingredient();
		product.setName(r.getParameter("name"));
		product.setSize(r.getParameter("size"));
		product.setType(r.getParameter("type"));
		
		item.setName(r.getParameter("ing_name"));
		item.setCategory(r.getParameter("ing_category"));
		
		List<Ingredient> items = new ArrayList<Ingredient>();
		items.add(item);
		product.setItems(items);
		
		return product;
	}
}
