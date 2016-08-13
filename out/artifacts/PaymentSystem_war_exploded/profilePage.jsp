<!DOCTYPE html>
<%@ page import="entity.User" %>
<%@ page import="service.CardService" %>
<%@ page import="service.implementation.CardServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Card" %>
<%@ page import="service.UserService" %>
<%@ page import="service.implementation.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<ul class="main-menu">
    <li><a href="/qwe">qwe</a></li>
    <li><a>Card management</a>
        <ul class="sub-menu">
            <li><a href="/add_new_card">Add new card</a></li>
            <li><a href="/delete_card">Delete card</a></li>
            <li><a href="/">Block card</a></li>
        </ul>
    </li>
    <li><a>Account management</a>
        <ul class="sub-menu">
            <li><a href="/">Add new account</a></li>
            <li><a href="/">Delete account</a></li>
        </ul>
    </li>
    <li><a href="/qwe">qwe</a></li>
    <li><a href="/qwe">qwe</a></li>
</ul>

<%
    User user = (User) session.getAttribute("user");
    response.getWriter().print("Hello, " + user.getFirstName() + " " + user.getSecondName() + " " + user.getPatronymic());
    CardService cardService = new CardServiceImpl();
    UserService userService = new UserServiceImpl();
    List<Card> cardList = cardService.getByUserId(user.getId());
%>
<br><br>
<%for (int i = 0; i < cardList.size(); i++) {%>
<%=cardList.get(i).getCardNumber()%><br>
<%=cardList.get(i).getAccountId()%><br>
<%=cardList.get(i).getExpireDate()%><br>
<%=cardList.get(i).getStatus()%><br>
<%=cardList.get(i).getTitle()%><br><br>
<%}%>
</body>
</html>
