package com.empanada.restaurant.servlets;

import com.empanada.restaurant.data.MenuDao;
import com.empanada.restaurant.data.MenuDaoFactory;
import com.empanada.restaurant.domain.MenuItem;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String searchItem = req.getParameter("searchTerm");

		if(searchItem != null){
			MenuDao menuDao = MenuDaoFactory.getMenuDao();

			List<MenuItem> resultItems = new ArrayList<MenuItem>(menuDao.find(searchItem));

			req.setAttribute("hasSearched", true);
			req.setAttribute("listItems", resultItems);
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/search.jsp");
		dispatcher.forward(req, resp);


	}

}
