package com.empanada.restaurant.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/thankYou.html")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"user"}))
public class ConfirmationReceivedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession sess = req.getSession();
        Double total = (Double)sess.getAttribute("total");

        if(total == null){
            resp.sendRedirect("/orderCreator.html");
            return;
        }

        req.setAttribute("total", total);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/order-received.jsp");
        dispatcher.forward(req, resp);

    }
}
