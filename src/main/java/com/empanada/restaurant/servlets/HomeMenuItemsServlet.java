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

@WebServlet("")
public class HomeMenuItemsServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> items = menuDao.getFullMenu();

		request.setAttribute("menuItems", items);

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request,response);

	}

}
