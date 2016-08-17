<!DOCTYPE html>
<%@ page import="entity.User" %>
<%@ page import="service.CardService" %>
<%@ page import="service.implementation.CardServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Card" %>
<%@ page import="service.UserService" %>
<%@ page import="service.implementation.UserServiceImpl" %>
<%@ page import="service.AccountService" %>
<%@ page import="service.implementation.AccountServiceImpl" %>
<%@ page import="entity.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="#a52a2a">

<ul class="main-menu">
    <li><a href="/qwe">qwe</a></li>
    <li><a>Card management</a>
        <ul class="sub-menu">
            <li><a href="/add_new_card">Add new card</a></li>
            <li><a href="/delete_card">Delete card</a></li>
            <li><a href="/block_card">Block card</a></li>
        </ul>
    </li>
    <li><a>Account management</a>
        <ul class="sub-menu">
            <li><a href="/add_new_account">Add new account</a></li>
            <li><a href="/delete_account">Delete account</a></li>
            <li><a href="/block_account">Block account</a></li>
        </ul>
    </li>
    <li><a href="/do_payment">Do payment</a></li>
    <li><a href="/qwe">qwe</a></li>
</ul>

<%
    User user = (User) session.getAttribute("user");
    response.getWriter().print("Hello, " + user.getFirstName() + "!");
    CardService cardService = new CardServiceImpl();
    UserService userService = new UserServiceImpl();
    List<Card> cardList = cardService.getByUserId(user.getId());
    AccountService accountService = new AccountServiceImpl();
    List<Account> accountList = accountService.getByUserId(user.getId());
%>

<lable>Here is your cadrs:
</lable>
<br><br>
<%for (int i = 0; i < cardList.size(); i++) {%>
<%=cardList.get(i).getCardNumber()%><br>
<%=cardList.get(i).getAccountId()%><br>
<%=cardList.get(i).getExpiryDate()%><br>
<%=cardList.get(i).getStatusId()%><br>
<%=cardList.get(i).getTitle()%><br><br>
<%}%>

<lable>Here is your accounts:
</lable>
<br><br>
<%for (int i = 0; i < accountList.size(); i++) {%>
<%=accountList.get(i).getId()%><br>
<%=accountList.get(i).getBalance()%><br>
<%=accountList.get(i).getNumber()%><br>
<%=accountList.get(i).getStatusId()%><br>
<%=accountList.get(i).getTitle()%><br><br>
<%}%>

</body>
</html>
