package com.empanada.restaurant.servlets;

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

@WebServlet("/thanksYou.html")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"user"}))
public class ConfirmationReceivedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        //String total = req.getParameter("total");

        HttpSession sess = req.getSession();
        Double total = (Double)sess.getAttribute("total");

        if(total == null){
            resp.sendRedirect("/orderCreator.html");
            return;
        }

        out.println("<html>");
        out.println("<body>");
        out.println("<h1> Empanada's Restaurant </h1>");
        out.println("<h2> Thanks for trust on us</h2>");

        out.println("Your order has been received. The total amuont is: $" + total );

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
