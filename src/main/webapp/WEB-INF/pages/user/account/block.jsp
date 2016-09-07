<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Block account</title>
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
                    <h2><fmt:message key="block_account"/></h2>
                    <h5>
                        <fmt:message key="welcome"/>, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}.
                        <br/></h5>
                    <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                        <h5 style="color: red"><fmt:message key="sorry_but_your_profile_is_blocked"/></h5>
                    </c:if>
                    <hr/>
                </div>
            </div>
            <c:if test="${sessionScope.user.status.toString()!='BLOCKED'}">
                <div class="col-md-9 col-sm-12 col-xs-12">
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
                                        <th><fmt:message key="status"/></th>
                                        <th><fmt:message key="title"/></th>
                                        <th><fmt:message key="check"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="account" items="${requestScope.accountList}">
                                        <tr>
                                            <th> ${account.number} </th>
                                            <th> ${account.id} </th>
                                            <th> ${account.balance} </th>
                                            <th> ${account.status} </th>
                                            <th> ${account.title} </th>
                                            <th>
                                                <div class="col-md-2">
                                                    <label>
                                                        <input type="radio" name="accountId" value="${account.id}"
                                                               onchange="changeAccountId(${account.id})"/>
                                                    </label>
                                                    <script>
                                                        function changeAccountId(accountIdValue) {
                                                            $("#blockAccountId").val(accountIdValue);
                                                            $("#blockBtAcc").removeAttr("disabled");
                                                        }
                                                    </script>
                                                </div>
                                            </th>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>


            <c:if test="${requestScope.accountList.size()==0}">
                <h1><fmt:message key="sorry_but_you_have_not_active_ac"/></h1>
            </c:if>
            <c:if test="${requestScope.accountList.size()!=0}">
            <div class="col-md-1"></div>
            <br/>
            <button class="btn btn-lg btn-block btn-warning" data-toggle="modal"
                    data-target="#blockAccountModal" id="blockBtAcc" disabled><fmt:message key="block_account"/>
            </button>


            <div class="modal fade" id="blockAccountModal" tabindex="-1" role="dialog"
                 aria-labelledby="gridSystemModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form method="post" action="/user/account/block">
                            <input type="hidden" name="accountId" id="blockAccountId"/>

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="gridSystemModalLabel"><fmt:message key="are_you_sure"/></h4>
                            </div>
                            <div class="modal-body">
                                <fmt:message key="do_you_really_want_to"/> <b><fmt:message key="block"/></b> <fmt:message key="this_account"/>?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="c_cancel"/></button>
                                <button type="submit" class="btn btn-danger"><fmt:message key="b_block"/></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
        </c:if>
    </div>
    <%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>


