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
    <li><a href="/history">Show history</a></li>
</ul>

<%
    User user = (User) session.getAttribute("user");
    response.getWriter().print(user.getFirstName() + " " + user.getSecondName() + " " + user.getPatronymic());
    CardService cardService = new CardServiceImpl();
    List<Card> cardList = cardService.getByUserId(user.getId());
    AccountService accountService = new AccountServiceImpl();
    List<Account> accountList = accountService.getByUserId(user.getId());
%>

<lable>Cards
</lable>
<br>
<table bgcolor="#deb887" border="2" bordercolor="white">
    <tr>
        <td>Card number</td>
        <td>Account</td>
        <td>Expiry date</td>
        <td>Status</td>
        <td>Title</td>
    </tr>
    <%for (int i = 0; i < cardList.size(); i++) {%>
    <tr>
        <td><%=cardList.get(i).getCardNumber()%>
        </td>
        <td><%=cardList.get(i).getAccountId()%>
        </td>
        <td><%=cardList.get(i).getExpiryDate()%>
        </td>
        <td><%=cardList.get(i).getStatusId()%>
        </td>
        <td><%=cardList.get(i).getTitle()%>
        </td>
    </tr>
    <%}%>
</table>
<br>

<lable>Accounts
</lable>
<br>
<table bgcolor="#deb887" border="2" bordercolor="white">
    <tr>
        <td>Number</td>
        <td>Account</td>
        <td>Balance</td>
        <td>Status</td>
        <td>Title</td>
    </tr>
    <%for (int i = 0; i < accountList.size(); i++) {%>
    <tr>
        <td><%=accountList.get(i).getId()%>
        </td>
        <td><%=accountList.get(i).getBalance()%>
        </td>
        <td><%=accountList.get(i).getNumber()%>
        </td>
        <td><%=accountList.get(i).getStatusId()%>
        </td>
        <td><%=accountList.get(i).getTitle()%>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>