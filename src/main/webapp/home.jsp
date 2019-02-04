<%@ page import="com.empanada.restaurant.domain.MenuItem" %>
<%@ page import="java.util.List" %>
<html>
<%@include file="header.jsp"%>
<body>

    <h2> Comida hecha con amor  </h2>

    <ul>
        <%
        List<MenuItem> menuItems = (List<MenuItem>)request.getAttribute("menuItems");

        for (MenuItem menuItem : menuItems){ %>
        <li><%=menuItem%></li>
        <%}%>
    </ul>

    <%@include file="footer.jsp"%>
</body>
</html>
