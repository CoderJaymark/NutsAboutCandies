package com.nutsaboutcandies.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nutsaboutcandies.model.Ingredient;
import com.nutsaboutcandies.model.Product;
import com.nutsaboutcandies.services.ProductBean;
import com.nutsaboutcandies.utilities.ImageUploader;

/**
 * Servlet implementation class AddProductConfirmation
 */
@WebServlet("/admin/product.confirmation")
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
maxFileSize=1024*1024*50,          // 50 MB
maxRequestSize=1024*1024*100)      // 100 MB
public class AddProductConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Product p = ProductBean.createProduct(request);
		for(Ingredient i: p.getItems())
			System.out.println(i.getName());
		request.setAttribute("product", p);
		ImageUploader.upload(getServletContext(), request);
		request.getRequestDispatcher("product_confirmation.jsp").forward(request, response);
	}

}
