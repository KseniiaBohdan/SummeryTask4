<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%--<fmt:setBundle basename="com.example.i18n.text" />--%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="${language}">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Login</title>
    <link href="/styles/assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="/styles/assets/css/font-awesome.css" rel="stylesheet"/>
    <link href="/styles/assets/css/custom.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

</head>
<body>

<div id="wrapper">
    <div id="page-wrapper">
        <nav id="page-inner">
            <div class="row ">

                <a href="LoginServlet?language=en">English</a>
                <a href="LoginServlet?language=ru">Russian</a>

                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <br/><br/>
                    <h2>${terminal}</h2>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <%--<strong> <fmt:message key="put_money_on_your_card" /> </strong>--%>
                        </div>
                        <div class="panel-body">
                            <form role="form" method="post" action="/put">
                                <br/>

                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                    <input type="text" required pattern="[0-9]{16}" class="form-control"
                                           placeholder="Card number* (Example: 0000000000000000)"
                                           name="cardNumber"/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="password" pattern="[0-9]{4}" required class="form-control"
                                           placeholder="Pin* (Example: 0000)" name="pin"/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="number" required class="form-control" placeholder="Sum*" name="sum"/>
                                </div>
                                <%--<button class="btn btn-primary " type="submit"><fmt:message key="put_money"/></button>--%>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <br/><br/>

                    <h2><fmt:message key="login"/></h2>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <%--<strong> <fmt:message key="enter_your_email_and_password"/> </strong>--%>
                        </div>
                        <div class="panel-body">
                            <form role="form" method="post">
                                <br/>

                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                    <input type="text" class="form-control" placeholder="Your email " name="Email"/>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input type="password" class="form-control" placeholder="Your password"
                                           name="Password"/>
                                </div>
                                <button class="btn btn-primary " onclick="submit"><fmt:message key="login"/></button>
                                <hr/>
                                <%--<fmt:message key="not_register"/>?<a href="/registration"><fmt:message key="click_here"/> </a>--%>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${requestScope.putMoneyResult !=null}">
                <br/>
                <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <%--<strong><fmt:message key="operation_successfull"/>!</strong>--%>
                </div>
            </c:if>

        </nav>
    </div>
</div>

<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>

</body>
</html>
