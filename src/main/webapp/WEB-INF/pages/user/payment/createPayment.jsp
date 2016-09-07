<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Create payment</title>
    <%@include file="/WEB-INF/pages/fragment/styles.jspf" %>

</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/pages/fragment/menu.jspf" %>
    <div id="page-wrapper">
        <div class="form-group">
                <nav id="page-inner">
                    <h2 style="color: red">
                        <fmt:message key="create_payment"/>
                    </h2>
                    <h5>
                        <fmt:message key="welcome"/>, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}.
                        <br/></h5>
                    <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                        <h5 style="color: red"><fmt:message key="sorry_but_your_profile_is_blocked"/></h5>
                    </c:if>
                    <c:if test="${sessionScope.user.status.toString()!='BLOCKED'}">
                    <hr/>
                    <div class="container">
                        <div class="row ">
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <fmt:message key="create_payment"/>
                                    </div>
                                    <div class="panel-body">

                                        <c:if test="${sessionScope.user.status.toString()!='BLOCKED'}">
                                            <form role="form" method="post" action="/user/payment/create">
                                                <br/>
                                                <fmt:message key="select_card"/>
                                                <div class="form-group input-group">
                                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>

                                                    <div class="form-group">
                                                        <select class="form-control" name="senderCardNumber">
                                                            <c:forEach var="card" items="${requestScope.cardList}">
                                                                <option> ${card.cardNumber} </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group input-group">
                                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                                    <input type="password" pattern="[0-9]{4}" class="form-control"
                                                           placeholder="Pin*"
                                                           name="pin"/>
                                                </div>
                                                <div class="form-group input-group">
                                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                                    <input type="number" pattern="^-" class="form-control"
                                                           placeholder="Sum*"
                                                           name="sum"/>
                                                </div>
                                                <div class="form-group input-group">
                                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                                    <input aria-multiline="true" type="text" class="form-control"
                                                           placeholder="Title"
                                                           name="title"/>
                                                </div>
                                                <fmt:message key="receivers_card"/>
                                                <div class="form-group input-group">
                                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                                    <input type="text" required pattern="[0-9]{16}"
                                                           class="form-control"
                                                           placeholder="Card number*"
                                                           name="receiverCardNumber"/>
                                                </div>
                                                <button class="btn btn-primary " onclick="submit"><fmt:message key="create_payment"/>
                                                </button>
                                            </form>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </c:if>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>