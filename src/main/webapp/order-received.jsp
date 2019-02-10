<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<%@include file="header.jsp"%>

<%Double total = (Double)request.getAttribute("total");%>

<h2> El pedido ha sido procesado! </h2>
<h3> Gracias por confiar en nosotros </h3>

<i>El total a pagar es de $<%=total%></i>

<br><br>
<form action="/live-orders.html">
    <input type="submit" value="Ver mis pedidos" />
</form>

<%@include file="footer.jsp"%>
</body>
</html>
