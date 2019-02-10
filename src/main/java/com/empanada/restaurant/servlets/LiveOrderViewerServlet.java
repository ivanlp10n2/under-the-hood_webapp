package com.empanada.restaurant.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/live-orders.html")
public class LiveOrderViewerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/live-orders.jsp");
        dispatcher.forward(req,resp);
    }
}
