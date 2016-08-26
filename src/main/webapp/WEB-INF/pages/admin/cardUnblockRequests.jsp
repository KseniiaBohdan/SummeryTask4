<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Unblock requests:

<table>
    <tr>
        <td>Card number</td>
        <td>Title</td>
        <td>Action</td>
    </tr>

    <c:forEach var="request" items="${requestScope.cardRequests}">
    <tr>
        <td>${request.cardNumber}</td>
        <td>${request.title}</td>
        <td><button onclick="location.href='/admin/card/action?cardnumber=${request.cardNumber}&action=unblock'">Unblock</button></td>
    </tr>
    </c:forEach>

</table>

</body>
</html>
