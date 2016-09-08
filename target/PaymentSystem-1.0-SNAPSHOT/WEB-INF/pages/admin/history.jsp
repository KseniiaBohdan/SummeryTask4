<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h2><fmt:message key="payments_history"/></h2>
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
                            <fmt:message key="history_jsp.admin.payments"/>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="userTable">
                                    <thead>
                                    <tr>
                                        <th><fmt:message key="id"/></th>
                                        <th><fmt:message key="from"/></th>
                                        <th><fmt:message key="to"/></th>
                                        <th><fmt:message key="sum"/></th>
                                        <th>Date</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="paymentModel" items="${requestScope.paymentModalList}">
                                        <tr class="odd gradeX">
                                            <th> ${paymentModel.payment.id} </th>
                                            <th> ${paymentModel.payment.cardNumberSender} <br/>
                                                    ${paymentModel.senderName}
                                            </th>
                                            <th> ${paymentModel.payment.cardNumberReceiver} <br/>
                                                    ${paymentModel.receiverName}
                                            </th>
                                            <th> ${paymentModel.payment.sum} </th>
                                            <th> ${paymentModel.payment.date} </th>
                                            <th> ${paymentModel.payment.paymentStatus} </th>
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

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--<title>Payments history</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<form name="selectDateForm" method="get" action="/admin/history">--%>
<%--From:--%>
<%--<input type="date" name="from" size="40"/> <br>--%>
<%--To:--%>
<%--<input type="date" name="to" size="40"/> <br>--%>
<%--<input type="submit" id="select" value="Select" size="40" onclick="document.selectDateForm.submit()"/>--%>

<%--</form>--%>


<%--<table bgcolor="#deb887" border="2" bordercolor="white">--%>
<%--<tr>--%>
<%--<td>Id</td>--%>
<%--<td>From</td>--%>
<%--<td>To</td>--%>
<%--<td>Sum</td>--%>
<%--<td>Date</td>--%>
<%--<td>Status</td>--%>
<%--</tr>--%>

<%--<c:forEach var="payment" items="${requestScope.paymentList}">--%>
<%--<tr>--%>
<%--<td> ${payment.id} </td>--%>
<%--<td> ${payment.cardNumberSender}  </td>--%>
<%--<!--kak dostat imia i familiu?-->--%>
<%--<td> ${payment.cardNumberReceiver} </td>--%>
<%--<td> ${payment.sum} </td>--%>
<%--<td> ${payment.date} </td>--%>
<%--<td> ${payment.paymentStatus} </td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>

<%--</body>--%>
<%--</html>--%>
