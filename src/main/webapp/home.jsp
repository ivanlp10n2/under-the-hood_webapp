<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<%@include file="header.jsp"%>
<body>

    <h2> Comida hecha con amor  </h2>

    <ul>
        <c:forEach items="${menuItems}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ul>

    <%@include file="footer.jsp"%>
</body>
</html>
