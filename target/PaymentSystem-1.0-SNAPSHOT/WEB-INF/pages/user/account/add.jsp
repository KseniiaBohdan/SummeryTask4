<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="container">
            <div class="row ">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <h1 style="color: black">Add account</h1>
                    <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                        <h5 style="color: red">Sorry, but your profile is blocked.</h5>
                    </c:if>
                    <c:if test="${sessionScope.user.status.toString()!='BLOCKED'}">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <form role="form" method="post" action="/account/add">
                                    <br/>
                                    Account number
                                    <div class="form-group input-group">
                                        <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                        <input type="text" required pattern="[0-9]{16}" class="form-control"
                                               placeholder="Account Number*"
                                               name="accountId"/>
                                    </div>
                                    Title
                                    <div class="form-group input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input type="text" class="form-control" placeholder="Title" name="title"/>
                                    </div>
                                    <button class="btn btn-primary " onclick="submit">Add</button>
                                    <hr/>
                                </form>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>
