<!DOCTYPE html>
<%@ page import="service.UserService" %>
<%@ page import="service.implementation.UserServiceImpl" %>
<%@ page import="service.AccountService" %>
<%@ page import="service.implementation.AccountServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="green">
<jsp:text>Add new card</jsp:text>
<br>

<form id="add-card" action="/add_new_card" method="post">
    <jsp:text> Input card number:</jsp:text>
    <br>
    <input type="number" align="right" border="10" required size="40" name="card_number"><br>

    <jsp:text> Input card expire date:</jsp:text>
    <br>
    <input type="date" align="right" border="10" required size="40" name="expire_date"><br>

    <jsp:text> Pin:</jsp:text>
    <br>
    <input type="password" align="right" border="10" required size="40" name="pin"><br>

    <jsp:text> Repeat pin:</jsp:text>
    <br>
    <input type="password" align="right" border="10" required size="40" name="repeat_pin"><br>

    <jsp:text> Title for card:</jsp:text>
    <br>
    <input type="text" align="right" border="10" size="40" name="title"/><br>

    <%
        UserService userService = new UserServiceImpl();
        Long userId = userService.getByEmail(session.getAttribute("email").toString()).getId();
        AccountService accountService = new AccountServiceImpl();
        List<Account> accountList = accountService.getByUserId(userId);
    %>
    <label>
        Select account
    </label>
    <br>
    <select name = "account_id">
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
