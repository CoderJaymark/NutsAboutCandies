package com.nuts.about.candies.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuts.about.candies.dao.Dao;
import com.nuts.about.candies.model.Product;
import com.nuts.about.candies.services.Inventory;
import com.nuts.about.candies.services.ProductCreator;
import com.nuts.about.candies.services.XMLRecorder;

@WebServlet("/add.jay")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AddProductServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Inventory inventory = XMLRecorder.retrieve();
		Product  product = ProductCreator.createProduct(request);
		inventory.addProduct(product);
		XMLRecorder.save(inventory);
		
		response.sendRedirect("index.html");
	}

}
