<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body bgcolor="#a52a2a">

${requestScope.userModel.user.firstName} ${requestScope.userModel.user.secondName} ${requestScope.userModel.user.patronymic}

<ul class="main-menu">
    <li><a>Card management</a>
        <ul class="sub-menu">
            <li><a href="/card/add">Add new card</a></li>
            <li><a href="/card/delete">Delete card</a></li>
            <li><a href="/card/block">Block card</a></li>
            <li><a href="/card/unblock">Unblock card</a></li>
        </ul>
    </li>
    <li><a>Account management</a>
        <ul class="sub-menu">
            <li><a href="/account/add">Add new account</a></li>
            <li><a href="/account/delete">Delete account</a></li>
            <li><a href="/account/block">Block account</a></li>
        </ul>
    </li>
    <li><a href="/do-payment">Do payment</a></li>
    <li><a href="/history">Show history</a></li>
</ul>

<form id="logout" action="/logout" method="GET">
    <input type="submit" value="Logout" size="40"/>
</form>

Cards: ${requestScope.userModel.cards.size()}
<br>
<table bgcolor="#deb887" border="2" bordercolor="white">
    <tr>
        <td>Card number</td>
        <td>Account</td>
        <td>Expiry date</td>
        <td>Status</td>
        <td>Title</td>
    </tr>

    <c:forEach var="cardList" items="${requestScope.userModel.cards}">
        <c:if test="${cardList.status != Status.DELETED}">
            <tr>
                <td> ${cardList.cardNumber} </td>
                <td> ${cardList.accountId} </td>
                <td> ${cardList.expiryDate} </td>
                <td> ${cardList.status} </td>
                <td> ${cardList.title} </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<br>

Accounts: ${requestScope.userModel.accounts.size()}
<br>
<table bgcolor="#deb887" border="2" bordercolor="white">
    <tr>
        <td>Number</td>
        <td>Account</td>
        <td>Balance</td>
        <td>Status</td>
        <td>Title</td>
    </tr>
    <c:forEach var="accountList" items="${requestScope.userModel.accounts}">
        <c:if test="${accountList.status != Status.DELETED}">
            <tr>
                <td> ${accountList.id} </td>
                <td> ${accountList.balance} </td>
                <td> ${accountList.number} </td>
                <td> ${accountList.status} </td>
                <td> ${accountList.title} </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>