<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <%@ include file="/WEB-INF/pages/fragment/menu.jspf" %>
    <div id="page-wrapper">
        <nav id="page-inner">
            <div class="col-md-12">
                <h2>Payments history</h2>
                <h5>
                    Welcome, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}.
                    <br/></h5>
                <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                    <h5 style="color: red">Sorry, but your profile is blocked.</h5>
                </c:if>
                <hr/>
            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Payments
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Number</th>
                                        <th>From</th>
                                        <th>To</th>
                                        <th>Sum</th>
                                        <th>Date</th>
                                        <th>Title</th>
                                        <th>Status</th>
                                        <th>Confim</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="paymentModel" items="${requestScope.paymentList}">
                                        <tr>
                                            <th> ${paymentModel.payment.number} </th>
                                            <th> ${paymentModel.payment.cardNumberSender} <br/>
                                                    ${paymentModel.senderName}</th>
                                            <th> ${paymentModel.payment.cardNumberReceiver} <br/>
                                                    ${paymentModel.receiverName}
                                            </th>
                                            <th> ${paymentModel.payment.sum} </th>
                                            <th> ${paymentModel.payment.date} </th>
                                            <th> ${paymentModel.payment.title} </th>
                                            <th> ${paymentModel.payment.paymentStatus} </th>
                                            <th>
                                                <c:if test="${paymentModel.payment.paymentStatus == 'PREPARED'}">
                                                    <button class="btn btn-success" style="width: 80%" type="submit"
                                                            onclick="location.href='/user/payment/confirm?paymentId=${paymentModel.payment.id}'">
                                                        Confirm
                                                    </button>
                                                </c:if>
                                                <c:if test="${paymentModel.payment.paymentStatus == 'COMPLETED'}">
                                                <form method="post" action="/user/payment/order">
                                                    <input type="hidden" name="paymentModelG" value="${paymentModel.payment.id}"/>
                                                    <button class="btn btn-success" style="width: 90%" type="submit"
                                                            onclick="submit">
                                                        Generate order
                                                    </button>
                                                    </form>
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
                <br/>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                ATM
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>Sum</th>
                                            <th>Card number</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="atmList" items="${requestScope.atmList}">
                                            <tr>
                                                <th> ${atmList.sum} </th>
                                                <th> ${atmList.cardNumberReceiver}</th>
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
        </nav>
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