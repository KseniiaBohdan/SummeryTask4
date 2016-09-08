<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%@include file="/WEB-INF/pages/fragment/styles.jspf" %>
    <link href="/styles/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>
    <title>User management</title>
    <link href="/styles/assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="/styles/assets/css/font-awesome.css" rel="stylesheet"/>
    <link href="/styles/assets/css/custom.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
    <link href="/styles/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>
</head>
<body>
<div id="wrapper">
    <%@include file="/WEB-INF/pages/fragment/adminMenu.jspf" %>
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2><fmt:message key="user_management"/></h2>
                    <h5>
                        <fmt:message
                                key="welcome"/>, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}.
                    </h5>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col-md-12">
                    <form name="findForm" action="/admin/user/management" method="get">
                        <div>
                            <select name="filterSelect" class="form-control"
                                    onchange="submit()">
                                <option value=""
                                        <c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>
                                    ALL
                                </option>
                                <c:forEach var="status" items="${requestScope.statuses}">
                                    <option value="${status.toString()}"
                                            <c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>
                                            ${status.toString()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>

                        <h5>Name</h5>
                        <input name="Name" size="40" type="text" pattern="(([A-Za-z]*){1,}\s{0,}){0,}"
                               value="${requestScope.Name}"/>
                        <%--<input type="submit" value="Find" size="40" class="form-control"/>--%>
                        <button class="btn btn-info" type="submit" value="Find">
                            Find
                        </button>
                        <br>
                        <br>
                    </form>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <fmt:message key="u_users"/>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="userTable">
                                    <thead>
                                    <tr>
                                        <th><fmt:message key="id"/></th>
                                        <th><fmt:message key="name"/></th>
                                        <th><fmt:message key="email"/></th>
                                        <th>Status</th>
                                        <th>Phone number</th>
                                        <th><fmt:message key="action"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="user" items="${requestScope.userList}">
                                        <tr class="odd gradeX">
                                            <th> ${user.id}
                                                <c:if test="${user.status.toString() != 'DELETED'}">
                                                    <button class="btn btn-info" style="width: 40%" type="submit"
                                                            onclick="location.href='/admin/user/info?userId=${user.id}'">
                                                        Info
                                                    </button>
                                                </c:if>
                                            </th>
                                            <th> ${user.firstName} ${user.secondName} ${user.patronymic}</th>
                                            <th> ${user.email}</th>
                                            <th> ${user.status}</th>
                                            <th> ${user.phoneNumber}</th>
                                            <th>
                                                <c:choose>
                                                    <c:when test="${user.status.toString() == 'BLOCKED'}">
                                                        <button class="btn btn-success" style="width: 60%" type="submit"
                                                                onclick="location.href='/admin/user/action?userId=${user.id}&action=unblock'">
                                                            <fmt:message key="unblock"/>
                                                        </button>
                                                    </c:when>
                                                    <c:when test="${user.status.toString() == 'ACTIVE'}">
                                                        <button class="btn btn-warning" style="width: 60%" type="submit"
                                                                onclick="location.href='/admin/user/action?userId=${user.id}&action=block'">
                                                            <fmt:message key="b_block"/>
                                                        </button>
                                                    </c:when>
                                                </c:choose>
                                                <c:if test="${user.status.toString() != 'DELETED'}">
                                                    <button class="btn btn-danger" style="width: 60%" type="submit"
                                                            onclick="location.href='/admin/user/action?userId=${user.id}&action=delete'">
                                                        <fmt:message key="d_delete"/>
                                                    </button>
                                                </c:if>
                                                <c:if test="${user.role.toString() == 'USER' && user.status.toString() == 'ACTIVE'}">
                                                    <button class="btn btn-info" style="width: 60%" type="submit"
                                                            onclick="location.href='/admin/user/action?userId=${user.id}&action=promote'">
                                                        <fmt:message key="p_promote"/>
                                                    </button>
                                                </c:if>
                                                <c:if test="${user.role.toString() == 'ADMIN'}">
                                                    <button class="btn btn-primary" style="width: 60%" type="submit"
                                                            onclick="location.href='/admin/user/action?userId=${user.id}&action=dismiss'">
                                                        <fmt:message key="d_dismiss"/>
                                                    </button>
                                                </c:if>
                                            </th>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
<script src="/styles/assets/js/jquery-1.10.2.js"></script>
<script src="/styles/assets/js/bootstrap.min.js"></script>
<script src="/styles/assets/js/jquery.metisMenu.js"></script>
<script src="/styles/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="/styles/assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#userTable').dataTable();
    });
</script>
<script src="/styles/assets/js/custom.js"></script>
</body>
</html>


<%--Role filter <br>--%>

<%--<form name="filterForm" action="/user/management" method="get">--%>
<%--<div class="filterSelect">--%>
<%--<select name="filterSelect" onchange="document.filterForm.submit();">--%>
<%--<option value="ALL"--%>
<%--<c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>--%>
<%--ALL--%>
<%--</option>--%>
<%--<c:forEach var="status" items="${requestScope.statuses}">--%>
<%--<option value="${status.toString()}"--%>
<%--<c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>--%>
<%-->${status.toString()}</option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</div>--%>
<%--<br>--%>
<%--</form>--%>

<%--<form name="sortForm" action="/user/management" method="get">--%>
<%--<input type="hidden" name="action" value="checking">--%>

<%--<div class="sortSelect">--%>
<%--<select name="sortSelect" onchange="document.sortForm.submit();">--%>
<%--<option value="ALPHABETICAL_ORDER"--%>
<%--<c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>--%>
<%--Name--%>
<%--</option>--%>
<%--<option value="SORT_EMAIL"--%>
<%--<c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>--%>
<%--Email--%>
<%--</option>--%>
<%--<option value="SORT_PHONE_NUMBER"--%>
<%--<c:if test="${requestScope.filterSelect == status.toString()}">selected</c:if>>--%>
<%--Phone number--%>
<%--</option>--%>
<%--</select>--%>
<%--</div>--%>
<%--<br>--%>
<%--</form>--%>


<%--All users: ${requestScope.userList.size()}--%>
<%--<table bgcolor="#deb887" border="2" bordercolor="white">--%>
<%--<tr>--%>
<%--<td> Id</td>--%>
<%--<td> Name</td>--%>
<%--<td> Email</td>--%>
<%--<td> Status</td>--%>
<%--<td> Phone number</td>--%>
<%--<td> Action</td>--%>
<%--</tr>--%>

<%--<c:set var="userList" value="${requestScope.userList}"/>--%>
<%--<c:forEach var="user" items="${requestScope.userList}">--%>
<%--<tr>--%>
<%--<td> ${user.id}</td>--%>
<%--<td> ${user.firstName} ${user.secondName} ${user.patronymic}</td>--%>
<%--<td> ${user.email}</td>--%>
<%--<td> ${user.status}</td>--%>
<%--<td> ${user.phoneNumber}</td>--%>
<%--<td>--%>
<%--<form method="post" action="/admin/action">--%>
<%--<c:choose>--%>
<%--<c:when test="${user.status.toString() == 'BLOCKED'}">--%>
<%--<button type="submit"--%>
<%--onclick="location.href='/admin/action?id=${user.id}&action=unblock'">--%>
<%--Unblock--%>
<%--</button>--%>
<%--</c:when>--%>
<%--<c:when test="${user.status.toString() == 'ACTIVE'}">--%>
<%--<button type="submit"--%>
<%--onclick="location.href='/admin/action?id=${user.id}&action=block'">--%>
<%--Block--%>
<%--</button>--%>
<%--</c:when>--%>
<%--</c:choose>--%>
<%--<c:if test="${user.status.toString() != 'DELETED'}">--%>
<%--<button type="submit"--%>
<%--onclick="location.href='/admin/action?id=${user.id}&action=delete'">--%>
<%--Delete--%>
<%--</button>--%>
<%--</c:if>--%>
<%--</form>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>

<%--</table>--%>

<%--</body>--%>
<%--</html>--%>
