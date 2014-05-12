package com.nutsaboutcandies.services;

import javax.servlet.http.HttpServletRequest;

import com.nutsaboutcandies.model.Product;

public class ProductBean {
	public static Product createProduct(HttpServletRequest req) {
		Product p = new Product();
		p.setName(req.getParameter("product_name"));
		p.setSize(req.getParameter("product_size"));
		p.setStock(Integer.parseInt(req.getParameter("product_stock")));
		p.setType(req.getParameter("product_type"));
		
		return p;
	}
}
