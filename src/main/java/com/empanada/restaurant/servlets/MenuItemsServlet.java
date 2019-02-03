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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/menu.html")
public class MenuItemsServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> items = menuDao.getFullMenu();


		out.println("<html><body>");
		out.println("<h1> Empanada's Restaurant </h1>");
		out.println("<h2> Menu Items </h2>");

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
