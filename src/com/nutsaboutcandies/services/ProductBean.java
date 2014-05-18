package com.nutsaboutcandies.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nutsaboutcandies.model.Ingredient;
import com.nutsaboutcandies.model.Product;

public class ProductBean {
	public static Product createProduct(HttpServletRequest req) {
		Product p = new Product();
		List<Ingredient> items = new ArrayList<Ingredient>();
		
		if(req.getParameter("id")!=null)
			p.setId(Integer.parseInt(req.getParameter("id")));
		p.setName(req.getParameter("product_name"));
		p.setSize(req.getParameter("product_size"));
		p.setStock(Integer.parseInt(req.getParameter("product_stock")));
		p.setType(req.getParameter("product_type"));
		if(!req.getParameter("hiddenFileName").isEmpty())
			p.setImage(req.getParameter("hiddenFileName"));
		else
			p.setImage("default.png");
		
		String[] itemNames = req.getParameterValues("ingredient_name");
		String[] itemCategories = req.getParameterValues("ingredient_category");
		System.out.println(itemNames.length);
		for(int i = 0; i < itemNames.length; i++) {
			Ingredient item = new Ingredient();
			item.setName(itemNames[i]);
			System.out.println("NAme : " + itemNames[i]);
			item.setCategory(itemCategories[i]);
			System.out.println("Categp : " + itemCategories[i]);
			items.add(item);
		}
		
		p.setItems(items);
		
		return p;
	}
}
