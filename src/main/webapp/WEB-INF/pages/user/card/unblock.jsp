<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Unblock card</title>
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
            <h1>Select card</h1>
            <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                <h5 style="color: red">Sorry, but your profile is blocked.</h5>
            </c:if>
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
                                            <p class="text-muted">Card number:</p>

                                            <p class="main-text">${card.cardNumber}</p>

                                            <p class="text-muted">Account:${card.accountId}<br/>
                                                Expiry date: ${card.expiryDate}<br/>
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
                                                $("#unblockCardNumber").val(cardNumberValue);
                                                $("#unblockButton").removeAttr("disabled");
                                                $("#disCardNum").val(cardNumberValue);
                                            }
                                        </script>
                                    </div>
                                </div>
                            </div>
                            Status: ${card.status}<br/>
                            Title: ${card.title}
                        </div>
                    </c:forEach>
                </div>
                <c:if test="${requestScope.cardList.size()==0}">
                    <h1>Sorry, you have not blocked cards.</h1>
                </c:if>
                <c:if test="${requestScope.cardList.size()!=0}">
                    <div class="col-md-1"></div>
                    <br/>
                    <button disabled class="btn btn-lg btn-block btn-warning" data-toggle="modal"
                            data-target="#unblockCardModal" id="unblockButton">Unblock card
                    </button>
                </c:if>
                <c:if test="${requestScope.unblockRequestResult !=null}">
                    <br/>

                    <div class="alert alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Operation success!</strong> Request was sent.
                    </div>
                </c:if>
            </c:if>
        </div>
    </div>
</div>


<div class="modal fade" id="unblockCardModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/card/unblock">
                <input type="hidden" name="cardNumber" id="unblockCardNumber"/>

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" style="color: red;" id="gridSystemModalLabel">Unblock request</h4>
                </div>
                <div class="form-group col-md-12">
                    <br/>
                    <label for="message-text" class="control-label">Card number:</label><br/>
                    <input class="form-control" type="text" disabled name="cardNumber" id="disCardNum"/> <br/>
                    <label for="message-text" class="control-label">Message:</label>
                    <textarea class="form-control" id="message-text" name="title"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Send request
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>

