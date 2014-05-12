package com.nutsaboutcandies.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nutsaboutcandies.dao.UserDao;
import com.nutsaboutcandies.user.User;
import com.nutsaboutcandies.utilities.HashMaker;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/admin/admin.login")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("admin") == null) {
		
			response.setContentType("text/html");
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(HashMaker.makeHash(password));
			UserDao dao = new UserDao();
			User user = dao.retrieveUser(email);
			
			System.out.println(user.getPassword());
			System.out.println(user.getRoleId() );
			
			if(user.getEmail() != null && user.getPassword().equals(HashMaker.makeHash(password)) && user.getRoleId() == 1) {
				session.setAttribute("admin", email);
				response.sendRedirect("index.jsp");
			} else {
				session.setAttribute("wrong_credentials", true);
				response.sendRedirect("login.jsp");
			}
		} else {
			System.out.println("Session for admin exists");
			response.sendRedirect("index.jsp");
		}
	}

}
