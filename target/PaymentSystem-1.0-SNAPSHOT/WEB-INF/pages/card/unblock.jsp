<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Unblock card</title>
    <link href="/styles/assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="/styles/assets/css/font-awesome.css" rel="stylesheet"/>
    <link href="/styles/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet"/>
    <link href="/styles/assets/css/custom.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
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
            <div class="col-md-1"></div>
            <br/>
            <button class="btn btn-lg btn-block btn-warning" data-toggle="modal"
                    data-target="#unblockCardModal">Unblock card
            </button>
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
                    <h4 class="modal-title" id="gridSystemModalLabel">Unblock request</h4>
                </div>
                </br>
                <div class="form-group col-md-12">
                    <label for="message-text" class="control-label">Message:</label>
                    <textarea class="form-control" id="message-text" name="title"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Send request</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/styles/assets/js/jquery-1.10.2.js"></script>
<script src="/styles/assets/js/bootstrap.min.js"></script>
<script src="/styles/assets/js/jquery.metisMenu.js"></script>
<script src="/styles/assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="/styles/assets/js/morris/morris.js"></script>
<script src="/styles/assets/js/custom.js"></script>
</body>
</html>

