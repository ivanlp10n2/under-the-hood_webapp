package com.empanada.restaurant.servlets;

import com.empanada.restaurant.data.MenuDao;
import com.empanada.restaurant.data.MenuDaoFactory;
import com.empanada.restaurant.domain.MenuItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchItem.html")
public class MenuSearchServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");

		MenuDao menuDao = MenuDaoFactory.getMenuDao();

		List<MenuItem> resultItems = new ArrayList<MenuItem>(menuDao.find(req.getParameter("searchTerm")));

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
