package com.empanada.restaurant.servlets;

import com.empanada.restaurant.domain.MenuItem;
import com.empanada.restaurant.data.MenuDataService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OrderCreatorServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");


		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Empanada's Restaurant </h1>");
		out.println("<h2> Order your food </h2>");
		out.println("<form action='orderReceived.html' method='POST'>");

		List<MenuItem> items = new MenuDataService().getFullMenu();

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
