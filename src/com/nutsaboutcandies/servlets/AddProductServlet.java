package com.nutsaboutcandies.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nutsaboutcandies.dao.Dao;
import com.nutsaboutcandies.model.Product;
import com.nutsaboutcandies.services.Inventory;
import com.nutsaboutcandies.services.ProductCreator;
import com.nutsaboutcandies.services.XMLRecorder;

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
