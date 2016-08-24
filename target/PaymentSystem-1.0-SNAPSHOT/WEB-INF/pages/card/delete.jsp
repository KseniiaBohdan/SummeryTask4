<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete card</title>
</head>
<body bgcolor="green">

<ul class="main-menu">
    <li><a>Card management</a>
        <ul class="sub-menu">
            <li><a href="/card/add">Add new card</a></li>
            <li><a href="/card/delete">Delete card</a></li>
            <li><a href="/card/block">Block card</a></li>
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

Delete card <br>

<form id="delete-card" action="/card/delete" method="post">

    Select card <br>
    <select name="card number">
        <c:forEach var="card" items="${requestScope.cardList}">
            <option>
            ${card.cardNumber}
            </option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="Delete card" size="40"/>

</form>
</body>
</html>
