<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Do payment</title>
</head>
<body bgcolor="#b8860b">

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

<form id="do payment" action="/do-payment" method="post">

    Sender:<br>
    Select card<br>
    <select name="sender card number">
        <c:forEach var="cardList" items="${requestScope.cardtList}">
            <option> ${cardList.cardNumber} </option>
        </c:forEach>
    </select>
    <br>

    Sum:<br>
    <input name="sum" pattern="[0-9]*" border="10" required size="40" type="number"><br>

    Title:<br>
    <input name="title" border="10" required size="40" type="text"><br><br>

    Receiver: <br>
    Card number: <br>
    <input name="receiver card number" pattern="[0-9]{16}" border="10" required size="40" type="number"><br>
    <input type="submit" value="Do payment" size="40"/>

</form>
</body>
</html>
