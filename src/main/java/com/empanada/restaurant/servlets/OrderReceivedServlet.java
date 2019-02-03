package com.empanada.restaurant.servlets;

import com.empanada.restaurant.data.MenuDao;
import com.empanada.restaurant.data.MenuDaoFactory;
import com.empanada.restaurant.domain.Order;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/orderReceived.html")

public class OrderReceivedServlet extends HttpServlet {
	
	MenuDao menuDao = MenuDaoFactory.getMenuDao();
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int maxId = menuDao.getFullMenu().size();
		Order order = menuDao.newOrder(request.getUserPrincipal().getName());
		for (int i = 0; i <maxId+1; i++) {
			String quantity = request.getParameter("item_" + i);
			 try  
			  {  
			    int q = Integer.parseInt(quantity);
			    if (q > 0) {
			    	menuDao.addToOrder(order.getId(), menuDao.getItem(i), q);
			    	order.addToOrder(menuDao.getItem(i), q);
			    }
			  }  
			  catch(NumberFormatException nfe)  
			  {  
			    //that's fine it just means there wasn't an order for this item 
			  }  
			  
		}
		
		System.out.println("A new order has been received.");
		
		Double total = menuDao.getOrderTotal(order.getId());
		
		HttpSession session = request.getSession();
		session.setAttribute("total", total);
		
		String redirectUrl = "/thankYou.html";
		redirectUrl = response.encodeURL(redirectUrl);
		response.sendRedirect(redirectUrl);

	}
}
