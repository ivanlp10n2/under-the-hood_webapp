package com.empanada.restaurant.servlets;


import com.empanada.restaurant.data.MenuDao;
import com.empanada.restaurant.data.MenuDaoFactory;
import com.empanada.restaurant.domain.MenuItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/order.html")
public class OrderCreatorServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> items = menuDao.getFullMenu();

		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Empanada's Restaurant </h1>");
		out.println("<h2> Order your food </h2>");
		out.println("<form action='orderReceived.html' method='POST'>");


		for (MenuItem item : items){
			out.println("<li>" + item.getName() + " " + item.getPrice() + "    <input type='text' name='item_" + item.getId() + "' /> "+ "</li>");
		}


		out.println("");
		out.println("");
		out.println("<input type='submit' />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");


	}
}
