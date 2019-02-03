package com.empanada.restaurant.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/helloWorld.html")
public class HelloWorldServlet extends HttpServlet {

	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1> Hello World </h1>");
		out.println("<p> the time is : " + new Date() + "</p>");
		out.println("</body></html>");
		out.close();
	}
}
