<!DOCTYPE html>
<%@ page import="service.AccountService" %>
<%@ page import="service.implementation.AccountServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Account" %>
<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add card</title>
</head>
<body bgcolor="#ffe4c4">
<jsp:text>Add new card</jsp:text>
<br>

<form id="add-card" action="/card/add" method="post">
    <jsp:text> Input card number:</jsp:text>
    <br>
    <input type="number" align="right" border="10" required size="40" name="card number" pattern="[0-9]{16}"><br>

    <jsp:text> Input card expire date:</jsp:text>
    <br>
    <input type="date" align="right" border="10" required size="40" name="expire date"><br>

    <jsp:text> Pin:</jsp:text>
    <br>
    <input type="password" align="right" border="10" required size="40" name="pin" pattern="[0-9]{4}"><br>

    <jsp:text> Repeat pin:</jsp:text>
    <br>
    <input type="password" align="right" border="10" required size="40" name="repeat pin" pattern="[0-9]{4}"><br>

    <jsp:text> Title for card:</jsp:text>
    <br>
    <input type="text" align="right" border="10" size="40" name="title"/><br>

    <%
        Long userId = ((User) session.getAttribute("user")).getId();
        AccountService accountService = new AccountServiceImpl();
        List<Account> accountList = accountService.getByUserId(userId);
    %>
    <label>
        Select account
    </label>
    <br>
    <select name = "account id">
        <%for (int i = 0; i < accountList.size(); i++) {%>
        <option>
            <%=accountList.get(i).getId()%>
        </option>
        <%}%>
    </select>
    <br>
    <input type="submit" value="Add card" size="40"/>

</form>
</body>
</html>
