<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<%@include file="header.jsp"%>
<body>

<h2> Buscá tu comida preferida! </h2>

<form action="/searchItem.html" method="GET">
    Menú que contengan : <input type="text" name="searchTerm"  /> <input type="submit" value="BUSCAR" />
</form>

<c:if test="${hasSearched}">
    <c:if test="${not empty listItems}" >
        <c:forEach items="${listItems}" var="item">
            <li> ${item} </li>
        </c:forEach>
    </c:if>
    <c:if test="${empty listItems}" >
        No se encontraron resultados
    </c:if>
</c:if>


<%@include file="footer.jsp"%>
</body>
</html>