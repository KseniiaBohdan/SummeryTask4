<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Add card</title>
    <%@include file="/WEB-INF/pages/fragment/styles.jspf" %>
    <style>
        input[type='radio'] {
            transform: scale(2);
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/pages/fragment/menu.jspf" %>
<div id="wrapper">
    <div id="page-wrapper">
        <div class="container">
            <div class="row ">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                <h2 style="color: black">New card</h2>
                <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                    <h5 style="color: red">Sorry, but your profile is blocked.</h5>
                </c:if>
                <c:if test="${sessionScope.user.status.toString()!='BLOCKED'}">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form role="form" method="post" action="/card/add">
                                <br/>
                                Card number
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                    <input type="text" pattern="[0-9]{16}" required class="form-control"
                                           placeholder="Card number*"
                                           name="cardNumber"/>
                                </div>
                                Expiry date
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                    <input type="date" class="form-control" required placeholder="Expiry date*"
                                           name="expiryDate"/>
                                </div>
                                Account number
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>

                                    <div class="form-group">
                                        <select multiple class="form-control" required name="accountId">
                                            <c:forEach var="account" items="${requestScope.accountList}">
                                                <option> ${account.id} </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                Pin
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="password" pattern="[0-9]{4}" required class="form-control" required
                                           placeholder="Pin*" name="pin1"/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="password" pattern="[0-9]{4}" class="form-control" required
                                           placeholder="Retype Pin*" name="pin2"/>
                                </div>
                                Title
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="text" class="form-control" placeholder="Title" name="title"/>
                                </div>
                                <button class="btn btn-primary " onclick="submit"></i>  Add
                                </button>
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