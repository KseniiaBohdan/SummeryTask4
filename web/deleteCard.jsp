<!DOCTYPE html>
<%@ page import="service.UserService" %>
<%@ page import="service.implementation.UserServiceImpl" %>
<%@ page import="service.AccountService" %>
<%@ page import="service.implementation.AccountServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Account" %>
<%@ page import="service.CardService" %>
<%@ page import="service.implementation.CardServiceImpl" %>
<%@ page import="entity.Card" %>
<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="green">
<jsp:text>Delete card</jsp:text>
<br>

<form id="delete-card" action="/delete_card" method="post">

    <%
        CardService cardService = new CardServiceImpl();
        UserService userService = new UserServiceImpl();
        Long user_id = userService.getByEmail(session.getAttribute("email").toString()).getId();
        List<Card> cardList = cardService.getByUserId(Long.valueOf(user_id));
    %>
    <label>
        Select card
    </label>
    <br>
    <select name = "card_number">
        <%for (int i = 0; i < cardList.size(); i++) {%>
        <option>
            <%=cardList.get(i).getCardNumber()%>
        </option>
        <%}%>
    </select>
    <br>
    <input type="submit" value="Delete card" size="40"/>

</form>
</body>
</html>
