package com.nutsaboutcandies.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nutsaboutcandies.dao.Dao;
import com.nutsaboutcandies.dao.InventoryDao;
import com.nutsaboutcandies.model.Product;
import com.nutsaboutcandies.services.Inventory;
import com.nutsaboutcandies.services.ProductBean;
import com.nutsaboutcandies.services.ProductCreator;
import com.nutsaboutcandies.services.XMLRecorder;
import com.nutsaboutcandies.utilities.ImageUploader;

@WebServlet("/admin/product.add")
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
				maxFileSize=1024*1024*50,          // 50 MB
				maxRequestSize=1024*1024*100)      // 100 MB
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = ProductBean.createProduct(request);
		ImageUploader.upload(getServletContext(), request);
        InventoryDao dao = new InventoryDao();
        if(dao.addProduct(p)) 
        	request.getSession().setAttribute("operation", "Success");
        else
        	request.getSession().setAttribute("operation", "Failed");
        
        request.getSession().setAttribute("productName", p.getName());
        response.sendRedirect("index.jsp");
	}
}
