<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="login" action="/profile" method="GET">
    <jsp:text> Input your email:</jsp:text><br>
    <input type="text" align="right" border="10" required size="40" name="email"><br>
    <jsp:text> Input your password:</jsp:text><br>
    <input type="password" align="right" border="10" required size="40" name="password"><br>
    <input type="submit" value="Login" size="40"/>
    </input>
</form>
</body>
</html>
