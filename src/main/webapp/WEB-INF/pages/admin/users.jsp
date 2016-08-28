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

Role filter <br>

<form name="filterForm" action="/user/management" method="get">
    <div class="filterSelect">
        <select name="filterSelect" onchange="document.filterForm.submit();">
            <option value="ALL" <c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>
                ALL</option>
            <c:forEach var="status" items="${requestScope.statuses}">
                <option value="${status.toString()}"
                        <c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>
                        >${status.toString()}</option>
            </c:forEach>
        </select>
    </div>
    <br>
</form>

<form name="sortForm" action="/user/management" method="get">
    <input type="hidden" name="action" value="checking">

    <div class="sortSelect">
        <select name="sortSelect" onchange="document.sortForm.submit();">
            <option value="ALPHABETICAL_ORDER" <c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>
                Name</option>
            <option value="SORT_EMAIL" <c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>
                Email</option>
            <option value="SORT_PHONE_NUMBER" <c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>
                Phone number</option>
        </select>
    </div>
    <br>
</form>

<form name="findForm" action="/user/management" method="get">
    Name<br>
    <input name="Name" size="40" type="text"  pattern="(([A-Za-z]*){1,}\s{0,}){0,}"/><br>
    <input type="submit" value="Find" size="40"/>
    <br>
</form>

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

    <c:set var="userList" value="${requestScope.userList}"/>
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
                            <button type="submit" onclick="location.href='/admin/action?id=${user.id}&action=unblock'">
                                Unblock
                            </button>
                        </c:when>
                        <c:when test="${user.status.toString() == 'ACTIVE'}">
                            <button type="submit" onclick="location.href='/admin/action?id=${user.id}&action=block'">
                                Block
                            </button>
                        </c:when>
                    </c:choose>
                    <c:if test="${user.status.toString() != 'DELETED'}">
                        <button type="submit" onclick="location.href='/admin/action?id=${user.id}&action=delete'">
                            Delete
                        </button>
                    </c:if>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
