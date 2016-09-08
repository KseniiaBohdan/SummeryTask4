<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
                    <h2><fmt:message key="profile"/></h2>
                    <h5>
                        <fmt:message key="welcome"/>, ${requestScope.userModel.user.firstName} ${requestScope.userModel.user.secondName} ${requestScope.userModel.user.patronymic}.
                        <br/></h5>
                    <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                        <h5 style="color: red"><fmt:message key="sorry_but_your_profile_is_blocked"/></h5>
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
                                <p class="text-muted"><fmt:message key="card_number"/>:<br/></p>

                                <p class="main-text">${cardList.cardNumber}</p>

                                <p class="text-muted"><fmt:message key="account"/>:${cardList.accountId}<br/>
                                    <fmt:message key="expiry_date"/>: ${cardList.expiryDate}<br/>
                                </p>
                            </div>
                        </div>
                        Status: ${cardList.status}<br/>
                        <fmt:message key="title"/>: ${cardList.title}
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
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="accountList" items="${requestScope.userModel.accounts}">
                                        <tr>
                                            <th> ${accountList.number} </th>
                                            <th> ${accountList.id} </th>
                                            <th> ${accountList.balance} </th>
                                            <th>Status</th>
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
