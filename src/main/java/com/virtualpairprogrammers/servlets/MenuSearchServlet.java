package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MenuSearchServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");

		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> resultItems = new ArrayList<MenuItem>(menuDataService.find(req.getParameter("searchTerm")));

		if(resultItems.size() < 1){
			out.println("No results were returned");
		}else{
			for (MenuItem item : resultItems){
				out.println("<li>" + item.getName() +"</li>");
			}
		}

		out.println("</body></html>");
		out.close();
	}
}
