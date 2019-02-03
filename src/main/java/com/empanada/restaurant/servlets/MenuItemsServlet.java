package com.empanada.restaurant.servlets;

import com.empanada.restaurant.domain.MenuItem;
import com.empanada.restaurant.data.MenuDataService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MenuItemsServlet extends HttpServlet {

	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> Empanada's Restaurant </h1>");
		out.println("<h2> Menu Items </h2>");

		ArrayList<MenuItem> items = new ArrayList<MenuItem>(new MenuDataService().getFullMenu());
		for (MenuItem item : items){
			out.println("<li>" + item.toString() + "</li>");
		}

		out.println("<br>");

		out.println("Please make your order" +
					"<br>");
		out.println("<form action=\"/order.html\">\n" +
					"    <input type=\"submit\" value=\"Order now \" />\n" +
					"</form>");

		out.println("</body></html>");
		out.close();
	}

}
