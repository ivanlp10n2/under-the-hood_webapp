<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<html>
<%@include file="header.jsp"%>
<body>
<h3>
    <font color="#dc143c"> Nombre de usuario o contraseña inválidos. Por favor intente nuevamente</font>
</h3>
<h2>Por favor ingresá con tu cuenta</h2>
<form action="j_security_check" method="POST">
    Username: <input type="text" name="j_username" />
    Password: <input type="password" name="j_password" />
    <input type="submit" value="login" />
</form>
<%@include file="footer.jsp"%>
</body></html>
