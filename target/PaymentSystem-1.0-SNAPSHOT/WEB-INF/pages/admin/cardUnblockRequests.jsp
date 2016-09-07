<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%@include file="/WEB-INF/pages/fragment/styles.jspf" %>
    <link href="/styles/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>
    <title>Payments history</title>
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
                    <h2><fmt:message key="unblock_card_requests"/></h2>
                    <h5>
                        <fmt:message key="welcome"/>, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}.
                    </h5>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <fmt:message key="r_requests"/>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="userTable">
                                    <thead>
                                    <tr>
                                        <th><fmt:message key="card_number"/></th>
                                        <th><fmt:message key="title"/></th>
                                        <th><fmt:message key="action"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="request" items="${requestScope.cardRequests}">
                                        <tr class="odd gradeX">
                                            <th>${request.cardNumber}</th>
                                            <th>${request.title}</th>
                                            <th>
                                                <button class="btn btn-success" style="width: 100%"
                                                        onclick="location.href='/admin/card/action?cardnumber=${request.cardNumber}&action=unblock'">
                                                    <fmt:message key="unblock"/>
                                                </button>
                                            </th>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <c:if test="${requestScope.cardUnblockResult!=null}">
                                <br/>
                                <div class="alert alert-success">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong><fmt:message key="operation_successfull"/></strong> <fmt:message key="card_was_unblocked"/>
                                </div>
                            </c:if>
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

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--<title></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--Unblock requests:--%>

<%--<table>--%>
<%--<tr>--%>
<%--<td>CardDto number</td>--%>
<%--<td>Title</td>--%>
<%--<td>Action</td>--%>
<%--</tr>--%>

<%--<c:forEach var="request" items="${requestScope.cardRequests}">--%>
<%--<tr>--%>
<%--<td>${request.cardNumber}</td>--%>
<%--<td>${request.title}</td>--%>
<%--<td><button onclick="location.href='/admin/card/action?cardnumber=${request.cardNumber}&action=unblock'">Unblock</button></td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>

<%--</table>--%>

<%--</body>--%>
<%--</html>--%>
