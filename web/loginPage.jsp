<!DOCTYPE html>
<link rel = "stylesheet" href = "bootstrap.css" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="green">
<jsp:text>Login</jsp:text><br><br>
<form id="login" action="/profile" method="GET">
    <jsp:text> Email</jsp:text><br>
    <input type="text" align="left" border="10" required size="40" name="email" pattern=".*@[A-Za-z0-9]*.[A-Za-z0-9]*"><br><br>
    <jsp:text> Password</jsp:text><br>
    <input type="password" align="right" border="10" required size="40" name="password" pattern="[a-zA-Z0-9]*"><br><br>
    <input type="submit" value="Login" size="40"/><br><br>
    </input>
</form>
<form id="registration" action="/registration" method="GET">
    <input type="submit" value="Registration" size="40"/>
</form>
</body>
</html>
