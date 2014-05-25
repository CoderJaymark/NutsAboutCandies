package com.nutsaboutcandies.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nutsaboutcandies.dao.InventoryDao;
import com.nutsaboutcandies.model.Product;
import com.nutsaboutcandies.user.Cart;

/**
 * Servlet implementation class RemoveCart
 */
@WebServlet("/cart.remove")
public class RemoveCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InventoryDao dao = new InventoryDao();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*60);
		Cart cart = (Cart)session.getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = cart.getProduct(id);
		
		cart.removeProduct(id);
		dao.addStock(p.getId(), p.getStock());
		session.setAttribute("cart", cart);
		
		response.sendRedirect("shop.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
