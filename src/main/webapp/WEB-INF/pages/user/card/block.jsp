<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Block card</title>
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
                    <h2><fmt:message key="block_card"/></h2>
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
                <c:forEach var="card" items="${requestScope.cardList}">
                    <div class="col-md-5 col-sm-6 col-xs-6">

                        <div class="panel panel-back noti-box">

                            <div class="row">
                                <div class="col-md-3">
                                     <span class="icon-box bg-color-red set-icon">
                    <i class="fa fa-table"></i>
                </span>
                                </div>
                                <div class="col-md-7">
                                    <div class="text-box ">
                                        <p class="text-muted"><fmt:message key="card_number"/>:</p>

                                        <p class="main-text">${card.cardNumber}</p>

                                        <p class="text-muted"><fmt:message key="account"/>:${card.accountId}<br/>
                                            <fmt:message key="expiry_date"/>: ${card.expiryDate}<br/>
                                        </p>
                                    </div>

                                </div>
                                <div class="col-md-2">
                                    <label>
                                        <input type="radio" name="cardNumber" value="${card.cardNumber}"
                                               onchange="changeCardNumber(${card.cardNumber})"/>
                                    </label>
                                    <script>
                                        function changeCardNumber(cardNumberValue) {
                                            $("#blockCardNumber").val(cardNumberValue);
                                            $("#blockBtSab").removeAttr("disabled");
                                        }
                                    </script>
                                </div>
                            </div>

                        </div>
                        Status: ${card.status}<br/>
                        <fmt:message key="title"/>: ${card.title}
                    </div>
                </c:forEach>
            </div>

            <c:if test="${requestScope.cardList.size()==0}">
                <h1><fmt:message key="sorry_you_have_not_active_c"/></h1>
            </c:if>
            <c:if test="${requestScope.cardList.size()!=0}">
            <div class="col-md-1"></div>
            <br/>
            <button class="btn btn-lg btn-block btn-warning" data-toggle="modal"
                    data-target="#blockCardModal" id="blockBtSab" disabled><fmt:message key="block_card"/>
            </button>
        </nav>
    </div>
    </c:if>
    </c:if>
</div>
</div>


<div class="modal fade" id="blockCardModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/user/card/block">
                <input type="hidden" name="cardNumber" id="blockCardNumber"/>

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="gridSystemModalLabel"><fmt:message key="are_you_sure"/></h4>
                </div>
                <div class="modal-body">
                    <fmt:message key="do_you_really_want_to"/> <b><fmt:message key="block"/></b> this card?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Block</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>

