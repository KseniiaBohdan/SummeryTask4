<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>User profile</title>
    <%@ include file="/WEB-INF/pages/fragment/styles.jspf" %>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/pages/fragment/menu.jspf" %>
    <div id="page-wrapper">
        <nav id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1>Profile</h1>
                    <h5>
                        Welcome, ${requestScope.userModel.user.firstName} ${requestScope.userModel.user.secondName} ${requestScope.userModel.user.patronymic}. <br/></h5>
                    <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                        <h5 style="color: red">Sorry, but your profile is blocked.</h5>
                    </c:if>
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
                                <p class="text-muted">Card number:<br/></p>

                                <p class="main-text">${cardList.cardNumber}</p>

                                <p class="text-muted">Account:${cardList.accountId}<br/>
                                    Expiry date: ${cardList.expiryDate}<br/>
                                </p>
                            </div>
                        </div>
                        Status: ${cardList.status}<br/>
                        Title: ${cardList.title}
                    </div>
                </c:forEach>
            </div>
            <br/><br/>

            <div class="row">
                <div class="col-md-9 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Accounts
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Account</th>
                                        <th>Balance</th>
                                        <th>Status</th>
                                        <th>Title</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="accountList" items="${requestScope.userModel.accounts}">
                                        <tr>
                                            <th> ${accountList.number} </th>
                                            <th> ${accountList.id} </th>
                                            <th> ${accountList.balance} </th>
                                            <th> ${accountList.status} </th>
                                            <th> ${accountList.title} </th>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
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
