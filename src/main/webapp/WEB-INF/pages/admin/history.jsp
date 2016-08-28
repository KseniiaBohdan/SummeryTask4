<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payments history</title>
</head>
<body>

<ul class="main-menu">
    <li><a href="/admin/profile">Profile</a></li>
    <li><a href="/user/management">User management</a></li>
    <li><a href="/admin/history">Payment History</a></li>
</ul>

<form name="selectDateForm" method="get" action="/admin/history">
    From:
    <input type="date" name="from" size="40"/> <br>
    To:
    <input type="date" name="to" size="40"/> <br>
    <input type="submit" id="select" value="Select" size="40" onclick="document.selectDateForm.submit()"/>

</form>



<table bgcolor="#deb887" border="2" bordercolor="white">
    <tr>
        <td>Id</td>
        <td>From</td>
        <td>To</td>
        <td>Sum</td>
        <td>Date</td>
        <td>Status</td>
    </tr>

    <c:forEach var="payment" items="${requestScope.paymentList}">
        <tr>
            <td> ${payment.id} </td>
            <td> ${payment.cardNumberSender}  </td>
            <!--kak dostat imia i familiu?-->
            <td> ${payment.cardNumberReceiver} </td>
            <td> ${payment.sum} </td>
            <td> ${payment.date} </td>
            <td> ${payment.paymentStatus} </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
