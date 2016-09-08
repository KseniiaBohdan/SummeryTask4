<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Unblock account</title>
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
                    <h2><fmt:message key="unblock_account"/></h2>
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
            <div class="row">
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
                                        <th>Status</th>
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
                                                            $("#unblockAccountId").val(accountIdValue);
                                                            $("#blockBtAcc").removeAttr("disabled");
                                                            $("#disAcctId").val(accountIdValue);

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
            </div>


            <c:if test="${requestScope.accountList.size()==0}">
            <h5 style="color: red"><fmt:message key="sorry_but_you_have_not_blocked_a"/></h5>
            </c:if>
            <c:if test="${requestScope.accountList.size()!=0}">
            <div class="col-md-1"></div>
            <br/>
            <button disabled class="btn btn-lg btn-block btn-warning" data-toggle="modal"
                    data-target="#unblockAccountModal" id="blockBtAcc"><fmt:message key="unblock_account"/>
            </button>
            </c:if>
            <c:if test="${requestScope.unblockAccountRequestResult !=null}">
            <br/>

            <div class="alert alert-success">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong><fmt:message key="operation_successfull"/></strong> <fmt:message key="request_was_sent"/>
            </div>
            </c:if>
            </c:if>
    </div>
</div>
</div>


<div class="modal fade" id="unblockAccountModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/user/account/unblock">
                <input type="hidden" name="accountId" id="unblockAccountId"/>

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" style="color: red;" id="gridSystemModalLabel"><fmt:message key="unblock_request"/></h4>
                </div>
                <div class="form-group col-md-12">
                    <br/>
                    <label for="message-text" class="control-label"><fmt:message key="account_id"/>:</label><br/>
                    <input class="form-control" type="text" disabled name="accountId" id="disAcctId"/> <br/>
                    <label for="message-text" class="control-label"><fmt:message key="message"/>:</label>
                    <textarea class="form-control" id="message-text" name="title"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="cancel"/></button>
                    <button type="submit" class="btn btn-danger"><fmt:message key="send_request"/>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>

