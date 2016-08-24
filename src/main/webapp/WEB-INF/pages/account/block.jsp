<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="#5f9ea0">

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

Block account<br>

<form id="block account" action="/account/block" method="post">

    Select account: <br>
    <select name="account id">
        <c:forEach var="account" items="${requestScope.accountList}">
            <option> ${account.id} </option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="Block account" size="40"/>

</form>
</body>
</html>

