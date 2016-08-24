<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body bgcolor="#ff7f50">

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

<table bgcolor="#deb887" border="2" bordercolor="white">
    <tr>
        <td>Number</td>
        <td>From</td>
        <td>To</td>
        <td>Sum</td>
        <td>Date</td>
        <td>Title</td>
        <td>Status</td>
    </tr>
    <c:forEach var="payment" items="${requestScope.paymentList}">
        <tr>
            <td> ${payment.number} </td>
            <td> ${payment.cardNumberSender} </td>
            <!--how to get name?-->
            <td> ${payment.cardNumberReceiver} </td>
            <!--how to get name?-->
            <td> ${payment.sum} </td>
            <td> ${payment.title} </td>
            <td> ${payment.date} </td>
            <td> ${payment.paymentStatus} </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>

</body>
</html>