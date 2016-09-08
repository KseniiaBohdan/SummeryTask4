<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%@include file="/WEB-INF/pages/fragment/styles.jspf" %>
    <link href="/styles/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>
    <title>User info</title>
    <link href="/styles/assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="/styles/assets/css/font-awesome.css" rel="stylesheet"/>
    <link href="/styles/assets/css/custom.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
    <link href="/styles/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/pages/fragment/adminMenu.jspf" %>
    <div id="page-wrapper">
        <nav id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>User Inform</h2>
                </div>
            </div>

            <hr/>
            <div class="row">
                <c:forEach var="cardList" items="${requestScope.userModel.cards}">
                    <div class="col-md-4 col-sm-6 col-xs-6">
                        <div class="panel panel-back noti-box">
                                <span class="icon-box bg-color-red set-icon">
                    <i class="glyphicon glyphicon-credit-card"></i>

                </span>

                            <div class="text-box ">
                                <p class="text-muted"><fmt:message key="card_number"/>:<br/></p>

                                <p class="main-text">${cardList.cardNumber}</p>

                                <p class="text-muted"><fmt:message key="account"/>:${cardList.accountId}<br/>
                                    <fmt:message key="expiry_date"/>: ${cardList.expiryDate}<br/>
                                </p>
                            </div>
                        </div>
                        Status: ${cardList.status}<br/>
                        <fmt:message key="title"/>: ${cardList.title}
                        <c:if test="${cardList.status.toString() == 'ACTIVE'}">
                            <button class="btn btn-warning" style="width: 100%" type="submit"
                                    onclick="location.href='/admin/user/card/block?cardId=${cardList.cardNumber}'">
                                <fmt:message key="b_block"/>
                            </button>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
            <br/><br/>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <fmt:message key="accounts"/>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th><fmt:message key="account"/></th>
                                        <th><fmt:message key="balance"/></th>
                                        <th>Status</th>
                                        <th><fmt:message key="title"/></th>
                                        <th><fmt:message key="check"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="accountList" items="${requestScope.userModel.accounts}">
                                        <tr>
                                            <th> ${accountList.number} </th>
                                            <th> ${accountList.id} </th>
                                            <th> ${accountList.balance} </th>
                                            <th>${accountList.status} </th>
                                            <th> ${accountList.title} </th>
                                            <th>
                                                <c:if test="${accountList.status.toString() == 'ACTIVE'}">
                                                    <button class="btn btn-warning" style="width: 100%" type="submit"
                                                            onclick="location.href='/admin/user/account/block?account=${accountList.id}'">
                                                        <fmt:message key="b_block"/>
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


                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="history_jsp.admin.payments"/>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th><fmt:message key="from"/></th>
                                            <th><fmt:message key="to"/></th>
                                            <th><fmt:message key="sum"/></th>
                                            <th>Date</th>
                                            <th><fmt:message key="title"/></th>
                                            <th>Status</th>
                                            <th><fmt:message key="confirm"/></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="payment" items="${requestScope.paymentL}">
                                            <tr>
                                                <th> ${payment.number} </th>
                                                <th> ${payment.cardNumberSender}</th>
                                                <th> ${payment.cardNumberReceiver}
                                                </th>
                                                <th> ${payment.sum} </th>
                                                <th> ${payment.date} </th>
                                                <th> ${payment.title} </th>
                                                <th> ${payment.paymentStatus} </th>
                                                <th>
                                                    <c:if test="${payment.paymentStatus == 'COMPLETED'}">
                                                        <form method="post" action="/user/payment/order">
                                                            <input type="hidden" name="paymentModelG"
                                                                   value="${payment.id}"/>
                                                            <button class="btn btn-info" style="width: 100%"
                                                                    type="submit"
                                                                    onclick="submit">
                                                                <fmt:message key="generate_order"/>
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
                </div>


                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <fmt:message key="atm"/>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th><fmt:message key="sum"/></th>
                                            <th><fmt:message key="card_number"/></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="atmList" items="${requestScope.atmL}">
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
</div>
<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>