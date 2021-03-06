<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Add account</title>
    <%@include file="/WEB-INF/pages/fragment/styles.jspf" %>
    <style>
        input[type='radio'] {
            transform: scale(2);
        }
    </style>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/pages/fragment/menu.jspf" %>
    <div id="page-wrapper">
        <nav id="page-inner">
            <div class="row ">
                <div class="col-md-12">
                    <h2><fmt:message key="add_account"/></h2>
                    <h5>
                        <fmt:message key="welcome"/>, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}.
                        <br/></h5>
                    <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                        <h5 style="color: red"><fmt:message key="sorry_but_your_profile_is_blocked"/></h5>
                    </c:if>
                    <hr/>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                <c:if test="${sessionScope.user.status.toString()!='BLOCKED'}">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form role="form" method="post" action="/user/account/add">
                                <br/>
                                <fmt:message key="account_number"/>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                    <input type="text" required pattern="[0-9]{16}" class="form-control"
                                           placeholder="Account Number*"
                                           name="accountId"/>
                                </div>
                                <fmt:message key="title"/>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="text" class="form-control" placeholder="Title" name="title"/>
                                </div>
                                <button class="btn btn-primary " onclick="submit"><fmt:message key="add"/></button>
                                <hr/>
                            </form>
                        </div>
                    </div>
                    <c:if test="${requestScope.addAccountResult !=null}">
                        <br/>

                        <div class="alert alert-success">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong><fmt:message key="operation_successfull"/></strong> <fmt:message key="account_was_added"/>
                        </div>
                    </c:if>
                </c:if>
            </div>
        </nav>
    </div>
</div>

<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>
