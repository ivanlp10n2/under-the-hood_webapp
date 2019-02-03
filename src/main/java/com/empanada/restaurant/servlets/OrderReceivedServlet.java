package com.empanada.restaurant.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empanada.restaurant.data.MenuDataService;

public class OrderReceivedServlet extends HttpServlet {
	
	MenuDataService menuDataService = new MenuDataService();
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int maxId = menuDataService.getFullMenu().size();
		for (int i = 0; i <maxId; i++) {
			String quantity = request.getParameter("item_" + i);
			 try  
			  {  
			    int q = Integer.parseInt(quantity);
			    if (q > 0) menuDataService.addToOrder(menuDataService.getItem(i), q);
			  }  
			  catch(NumberFormatException nfe)  
			  {  
			    //that's fine it just means there wasn't an order for this item 
			  }  
			  
		}
		
		Double total = menuDataService.getOrderTotal();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Empanada's Restaurant </h1>");
		out.println("<h2> Order your food </h2>");

		out.println("Thank you - your order has been received. You need to pay $" + total);
				
		out.println("</body></html>");
		out.close();
	}
}
