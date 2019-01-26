package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

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

		ArrayList<MenuItem> items = new ArrayList<MenuItem>(new MenuDataService().getFullMenu());
		for (MenuItem item : items){
			out.println("<li>" + item.toString() + "</li>");
		}

		out.println("</body></html>");
		out.close();
	}

}
