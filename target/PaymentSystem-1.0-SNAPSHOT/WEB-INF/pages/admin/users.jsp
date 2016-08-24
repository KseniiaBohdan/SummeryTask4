<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User management</title>
</head>
<body>

<ul class="main-menu">
    <li><a href="/admin/profile">Profile</a></li>
    <li><a href="/user/management">User management</a></li>
    <li><a href="/admin/history">Payment History</a></li>
</ul>

All users: ${requestScope.userList.size()}
<table bgcolor="#deb887" border="2" bordercolor="white">
    <tr>
        <td> Id</td>
        <td> Name</td>
        <td> Email</td>
        <td> Status</td>
        <td> Phone number</td>
        <td> Action</td>
    </tr>
    <c:forEach var="user" items="${requestScope.userList}">
        <tr>
            <td> ${user.id}</td>
            <td> ${user.firstName} ${user.secondName} ${user.patronymic}</td>
            <td> ${user.email}</td>
            <td> ${user.status}</td>
            <td> ${user.phoneNumber}</td>
            <td>
                <form method="post" action="/admin/action">
                    <c:choose>
                        <c:when test="${user.status.toString() == 'BLOCKED'}">
                            <button onclick="location.href='/admin/action?id=${user.id}&action=unblock'">Unblock</button>
                        </c:when>
                        <c:when test="${user.status.toString() == 'ACTIVE'}">
                            <button onclick="location.href='/admin/action?id=${user.id}&action=block'">Block</button>
                        </c:when>
                    </c:choose>
                <c:if test="${user.status.toString() != 'DELETED'}">
                    <button type="submit" onclick="location.href='/admin/action?id=${user.id}&action=delete'">Delete</button>
                </c:if>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
