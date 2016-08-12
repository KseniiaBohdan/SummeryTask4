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

<ul class="css-menu-3">
    <li><a href="/add_new_card">Add new card</a></li>
</ul>

<%
    User user = (User) session.getAttribute("user");
    response.getWriter().print("Hello, " + user.getFirstName() + " " + user.getSecondName() + " " + user.getPatronymic());
    CardService cardService = new CardServiceImpl();
    UserService userService = new UserServiceImpl();
    List<Card> cardList = cardService.getByUserId(user.getId());%>
<br><br>
<%
    for (int i = 0; i < cardList.size(); i++) {%>
<%=cardList.get(i).getCardNumber()%><br>
<%=cardList.get(i).getAccountId()%><br>
<%=cardList.get(i).getExpireDate()%><br>
<%=cardList.get(i).getStatus()%><br>
<%=cardList.get(i).getTitle()%><br><br>
<%
    }
%>
</body>
</html>
