package com.nutsaboutcandies.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nutsaboutcandies.user.Cart;

/**
 * Servlet implementation class UpdateCart
 */
@WebServlet("/cart.update")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCart() {
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
		String[] in = request.getParameterValues("quantities");
		int[] quantities = new int[in.length];
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*60);
		Cart cart = (Cart)session.getAttribute("cart");
		for(int i  = 0; i < in.length; i++) {
			quantities[i] = Integer.parseInt(in[i]);
		}
		
//		int[] q = (int[]) request.getSession().getAttribute("quantities");
		int[] q = cart.getQuantities();
		System.out.println(Arrays.equals(q, quantities));
		if(Arrays.equals(q, quantities)) {
			response.sendRedirect("cart.jsp");
			return;
		}
		for(int i = 0; i < q.length; i++) {
			System.out.print(q[i] + " : ");
			System.out.println(quantities[i]);
		}
		cart.updateStock(quantities);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart.jsp");
		
	}

}
