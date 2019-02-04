<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.empanada.restaurant.domain.MenuItem" %>
<%@ page import="java.util.List" %>
<html>
    <body>
    <%@include file="header.jsp"%>
        <h2> Armá tu pedido: </h2>
        <form action='/orderReceived.html' method='POST'>

        <ul>
            <% List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
                for (MenuItem item : menuItems){ %>
            <li> <%=item.getName()%>  <%=item.getPrice()%>  <input type='text' name='item_<%=item.getId()%>' /> </li>
            <%}%>
        </ul>
        <input type='submit' value='Hacer pedido ya'/>
        </form>

    <%@include file="footer.jsp"%>
    </body>
</html>