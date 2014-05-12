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
import com.nutsaboutcandies.model.Product;
import com.nutsaboutcandies.services.Inventory;
import com.nutsaboutcandies.services.ProductBean;
import com.nutsaboutcandies.services.ProductCreator;
import com.nutsaboutcandies.services.XMLRecorder;

@WebServlet("/admin/add.jay")
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
				maxFileSize=1024*1024*50,          // 50 MB
				maxRequestSize=1024*1024*100)      // 100 MB
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = ProductBean.createProduct(request);
		String[] ings = request.getParameterValues("ingredient_name");
		String[] types = request.getParameterValues("ingredient_type");
		System.out.println(ings.length + " : " + types.length);
		for(int i = 0; i < ings.length; i++ )
		System.out.println(ings[i] + " : " + types[i]);
		System.out.println(p.getName());
		
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	System.out.println(request.getParameter("fileName"));
        	System.out.println(request.getParameter("hiddenFileName"));
            // get access to file that is uploaded from client
            Part p1 = request.getPart("fileName");
            InputStream is = p1.getInputStream();

            // read filename which is sent as a part
            Part p2  = request.getPart("hiddenFileName");
            Scanner s = new Scanner(p2.getInputStream());
            String filename = s.nextLine();    // read filename from stream

            // get filename to use on the server
            String outputfile = this.getServletContext().getRealPath(filename);  // get path on the server
            FileOutputStream os = new FileOutputStream (outputfile);
            System.out.println(outputfile);
            // write bytes taken from uploaded file to target file
            int ch = is.read();
            while (ch != -1) {
                 os.write(ch);
                 ch = is.read();
            }
            os.close();
            response.sendRedirect("index.jsp");
        }
        catch(Exception ex) {
           out.println("Exception -->" + ex.getMessage());
           out.print(ex.getClass().getName());
        }
        finally { 
            out.close();
        }
//		
//		// gets absolute path of the web application
//        String applicationPath = request.getServletContext().getRealPath("");
//        // constructs path of the directory to save uploaded file
//        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
//        // creates the save directory if it does not exists
//        System.out.println(uploadFilePath);
//        File fileSaveDir = new File(uploadFilePath);
//        if (!fileSaveDir.exists()) {
//            fileSaveDir.mkdirs();
//        }
//         
//        String fileName = null;
//        //Get all the parts from request and write it to the file on server
//        for (Part part : request.getParts()) {
//            fileName = getFileName(part);
//            part.write(uploadFilePath + File.separator + fileName);
//        }
        
	}
	
    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
            	 return token.substring(token.indexOf("=") + 2, token.length()-1);
               
            }
        }
        return "";
    }

}
