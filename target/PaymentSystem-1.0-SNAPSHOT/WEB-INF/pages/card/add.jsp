<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add card</title>
</head>
<body bgcolor="#ffe4c4">

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

Add new card <br>

<form id="add-card" action="/card/add" method="post">
    Input card number:<br>
    <input type="number" align="right" border="10" required size="40" name="card number" pattern="[0-9]{16}"><br>

    Input card expire date:<br>
    <input type="date" align="right" border="10" required size="40" name="expire date"><br>

    Pin:<br>
    <input type="password" align="right" border="10" required size="40" name="pin" pattern="[0-9]{4}"><br>

    Repeat pin:<br>
    <input type="password" align="right" border="10" required size="40" name="repeat pin" pattern="[0-9]{4}"><br>

    Title for card:<br>
    <input type="text" align="right" border="10" size="40" name="title"/><br>

    Select account<br>
    <select name="account id">
        <c:forEach var="account" items="${requestScope.accountList}">
            <option> ${account.id} </option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="Add card" size="40"/>

</form>
</body>
</html>
