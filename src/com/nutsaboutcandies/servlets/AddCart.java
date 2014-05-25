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
 * Servlet implementation class AddCart
 */
@WebServlet("/cart.add")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
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
		Cart cart;
		InventoryDao dao = new InventoryDao();
		int id = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		Product p = dao.retrieveProduct(id);
		if(p.getStock() <= 0) {
			session.setAttribute("stock_error", "Out of stock");
			session.setAttribute("product_name", p.getName());
			response.sendRedirect("shop.jsp");
			return;
		} else if(quantity > p.getStock()) {
			session.setAttribute("stock_error", "Over stock");
			session.setAttribute("stock", p.getStock());
			response.sendRedirect("shop.jsp");
			return;
		}
		
		cart = (Cart)session.getAttribute("cart");
		if(cart == null ) 
			cart = new Cart();
		
		
		
		p.setStock(quantity);
		cart.addProduct(p);
		dao.removeStock(id, quantity);
		session.setAttribute("cart", cart);
		
		response.sendRedirect("shop.jsp");
	}

}
