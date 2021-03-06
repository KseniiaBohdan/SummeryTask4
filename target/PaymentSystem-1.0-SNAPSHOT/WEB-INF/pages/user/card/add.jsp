<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
        <nav id="page-inner">
            <div class="row ">
                <div class="col-md-12">
                    <h2><fmt:message key="add_new_card"/></h2>
                    <h5>
                        <fmt:message key="welcome"/>, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}.
                        <br/></h5>
                    <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                        <h5 style="color: red"><fmt:message key="sorry_but_your_profile_is_blocked"/></h5>
                    </c:if>
                    <hr/>
                </div>
            </div>
            <div class="row ">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <c:if test="${sessionScope.user.status.toString()!='BLOCKED'}">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <form role="form" method="post" action="/user/card/add">
                                    <br/>
                                    <fmt:message key="card_number"/>
                                    <div class="form-group input-group">
                                        <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                        <input type="text" pattern="[0-9]{16}" required class="form-control"
                                               placeholder="Card number*"
                                               name="cardNumber"/>
                                    </div>
                                    <fmt:message key="expiry_date"/>
                                    <div class="form-group input-group">
                                        <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                        <input type="date" class="form-control" required placeholder="Expiry date*"
                                               name="expiryDate"/>
                                    </div>
                                    <fmt:message key="account_number"/>
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
                                    <fmt:message key="pin"/>
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
                                    <fmt:message key="title"/>
                                    <div class="form-group input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input type="text" class="form-control" placeholder="Title" name="title"/>
                                    </div>
                                    <button class="btn btn-primary" onclick="submit"></i>  <fmt:message key="add"/>
                                    </button>
                                </form>
                            </div>
                        </div>
                        <c:if test="${requestScope.addCardResult !=null}">
                            <br/>

                            <div class="alert alert-success">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong><fmt:message key="operation_successfull"/></strong> <fmt:message key="card_was_added"/>
                            </div>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </nav>
    </div>
</div>
</div>
<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>