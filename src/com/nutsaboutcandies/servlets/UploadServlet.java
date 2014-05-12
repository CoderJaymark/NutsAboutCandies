package com.nutsaboutcandies.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
  
@WebServlet("/FileUploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
  
    private static final long serialVersionUID = 205242440643911308L;
    String imageName = ""; 
    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private static final String UPLOAD_DIR = "uploads";
      
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	
        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
         
        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }
        
        System.out.println(imageName);
        request.setAttribute("message", fileName + " File uploaded successfully!");
        request.setAttribute("image", UPLOAD_DIR + "/" + imageName);
        String referer = request.getHeader("Referer");
        System.out.println(fileSaveDir.getAbsolutePath() + "\\" + imageName);
        request.setAttribute("image",  UPLOAD_DIR + "/" + imageName);
        referer = referer.substring(referer.lastIndexOf("/"));
         
        System.out.println("<img src='"+UPLOAD_DIR + "/" + imageName+"'>");
        response.getWriter().write("<img src='"+UPLOAD_DIR + "/" + imageName+"'>");

//        getServletContext().getRequestDispatcher(referer).forward(
//                request, response);
//        response.sendRedirect("ajax.jsp");
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
            	imageName = token.substring(token.indexOf("=") + 2, token.length()-1);
                return imageName;
            }
        }
        return "";
    }
}