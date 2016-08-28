<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>User profile</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="/styles/assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FONTAWESOME STYLES-->
    <link href="/styles/assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- MORRIS CHART STYLES-->
    <link href="/styles/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet"/>
    <!-- CUSTOM STYLES-->
    <link href="/styles/assets/css/custom.css" rel="stylesheet"/>
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/pages/fragment/menu.jspf"%>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <nav id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>Profile</h2>
                    <h5>
                        Welcome, ${requestScope.userModel.user.firstName} ${requestScope.userModel.user.secondName} ${requestScope.userModel.user.patronymic}. </h5>
                </div>
            </div>
            <!-- /. ROW  -->

            <hr/>
            <div class="row">
                <c:forEach var="cardList" items="${requestScope.userModel.cards}">
                    <c:if test="${cardList.status != Status.DELETED}">
                        <div class="col-md-4 col-sm-6 col-xs-6">
                            <div class="panel panel-back noti-box">
                                <span class="icon-box bg-color-red set-icon">
                    <i class="fa fa-table"></i>
                </span>
                                <div class="text-box ">
                                    <p class="text-muted">Card number:<br/></p>

                                    <p class="main-text">${cardList.cardNumber}</p>

                                    <p class="text-muted">Account:${cardList.accountId}<br/>
                                        Expiry date: ${cardList.expiryDate}<br/>
                                    </p>
                                </div>
                            </div>
                            Status: ${cardList.status}<br/>
                            Title: ${cardList.title}
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <br/><br/>

            <!-- /. NAV SIDE  -->
            <div class="row">
                <div class="col-md-9 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Responsive Table Example
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
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="accountList" items="${requestScope.userModel.accounts}">
                                        <c:if test="${accountList.status != Status.DELETED}">
                                            <tr>
                                                <th> ${accountList.number} </th>
                                                <th> ${accountList.id} </th>
                                                <th> ${accountList.balance} </th>
                                                <th> ${accountList.status} </th>
                                                <th> ${accountList.title} </th>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </nav>
    </div>
</div>
</div>
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="/styles/assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="/styles/assets/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="/styles/assets/js/jquery.metisMenu.js"></script>
<!-- MORRIS CHART SCRIPTS -->
<script src="/styles/assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="/styles/assets/js/morris/morris.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="/styles/assets/js/custom.js"></script>


</body>
</html>
