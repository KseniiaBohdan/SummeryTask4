<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add account</title>
</head>
<body bgcolor="#deb887">
<jsp:text>Add new account</jsp:text>
<br>

<form id="add account" action="/account/add" method="post">
  <jsp:text> Input account number:</jsp:text>
  <br>
  <input type="number" align="right" border="10" required size="40" name="id" pattern="[0-9]{16}"><br>

  <jsp:text> Balance:</jsp:text>
  <br>
  <input type="number" align="right" border="10" required size="40" name="balance" pattern="[0-9]*"><br>

  <jsp:text> Title for account:</jsp:text>
  <br>
  <input type="text" align="right" border="10" size="40" name="title"/><br>


  <input type="submit" value="Add account" size="40"/>

</form>
</body>
</html>
