<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="form-group">
            <h1>Select account</h1>
            <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
            <h5 style="color: red">Sorry, but your profile is blocked.</h5>
            </c:if>
            <c:if test="${sessionScope.user.status.toString()!='BLOCKED'}">
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
                                        <th>Check</th>
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
            </div>

            <c:if test="${requestScope.accountList.size()==0}">
            <h1>Sorry, you have not active accounts.</h1>
            </c:if>
            <c:if test="${requestScope.accountList.size()!=0}">
            <div class="col-md-1"></div>
            <br/>
            <button class="btn btn-lg btn-block btn-warning" data-toggle="modal"
                    data-target="#blockAccountModal" id="blockBtAcc" disabled>Block account
            </button>
            </c:if>

            <div class="modal fade" id="blockAccountModal" tabindex="-1" role="dialog"
                 aria-labelledby="gridSystemModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form method="post" action="/account/block">
                            <input type="hidden" name="accountId" id="blockAccountId"/>

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="gridSystemModalLabel">Are you sure?</h4>
                            </div>
                            <div class="modal-body">
                                Do you really want to <b>block</b> this account?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-danger">Submit blocking</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            </c:if>
            <%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>


