<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Register</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="/styles/assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FONTAWESOME STYLES-->
    <link href="/styles/assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- CUSTOM STYLES-->
    <link href="/styles/assets/css/custom.css" rel="stylesheet"/>
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

</head>
<body>
<div class="container">
    <div class="row text-center  ">
        <div class="col-md-12">
            <br/><br/>
            <h2> <fmt:message key="registration_jsp.register"/></h2>
        </div>
    </div>
    <form method="post">
        <form role="form" method="post" action="/registration/">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong> <fmt:message key="registration_jsp.step1"/> </strong>
                    </div>
                    <div class="panel-body">
                            <br/>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="FirstName" placeholder="First Name*"
                                        value="${requestScope.FirstName}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="SecondName"
                                       placeholder="Second Name*" value="${requestScope.SecondName}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="Patronymic" placeholder="Patronymic*"
                                       value="${requestScope.Patronymic}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" pattern="+[0-9]{12}" name="PhoneNumber"
                                       placeholder="Phone number*" value="${requestScope.PhoneNumber}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon">@</span>
                                <input type="text" class="form-control" name="Email" placeholder="Your Email*"
                                       value="${requestScope.Email}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="Password1"
                                       placeholder="Enter Password*"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="Password2"
                                       placeholder="Retype Password*"/>
                            </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong> <fmt:message key="registration_jsp.step2"/> </strong>
                    </div>
                    <div class="panel-body">
                            <br/>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="number" class="form-control" pattern="[0-9]{16}" name="CardNumber"
                                       placeholder="Card number*" value="${requestScope.CardNumber}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="date" class="form-control" name="ExpiryDate"
                                       placeholder="Expiry date*" value="${requestScope.ExpiryDate}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="Pin1"
                                       placeholder="Enter Pin*"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="Pin2"
                                       placeholder="Retype Pin*"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="CardTitle" placeholder="Title"
                                       value="${requestScope.CardTitle}"/>
                            </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong> <fmt:message key="registration_jsp.step3"/> </strong>
                    </div>
                    <div class="panel-body">
                            <br/>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="number" class="form-control" pattern="[0-9]{16}" name="AccountNumber"
                                       placeholder="Account number*" value="${requestScope.AccountNumber}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="AccountTitle"
                                       placeholder="Title" value="${requestScope.AccountTitle}"/>
                            </div>

                            <button type="submit" class="btn btn-success "><fmt:message key="register_me"/></button>
                            <hr/>
                        <fmt:message key="already_register"/> <a href="/login/*"> <fmt:message key="login_here"/></a>
                    </div>
                </div>
            </div>
        </div>
    </form>
        </form>
</div>


<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf"%>

</body>
</html>
