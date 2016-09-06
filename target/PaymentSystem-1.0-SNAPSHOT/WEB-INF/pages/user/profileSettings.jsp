<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Profile settings</title>
    <%@ include file="/WEB-INF/pages/fragment/styles.jspf" %>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/pages/fragment/menu.jspf" %>
    <div id="page-wrapper">
        <nav id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>Profile settings</h2>
                    <h5>Welcome, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}.
                    </h5>
                    <c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
                        <h5 style="color: red">Sorry, but your profile is blocked.</h5>
                    </c:if>
                </div>
            </div>

            <hr/>
            <div class="row">
                <div class="col-md-9 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Accounts
                        </div>
                        <div class="panel-body">
                            <form action="/user/profile/settings" method="post">
                                <br/>
                                New email
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                    <input type="email" class="form-control"
                                           placeholder="Email" name="email" value="${sessionScope.user.email}"/>
                                </div>
                                New password
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                    <input type="password" class="form-control"
                                           placeholder="Password" name="password"/>
                                </div>
                                New phone number
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                                    <input type="text" pattern="+[0-9]{12}" class="form-control"
                                           placeholder="Phone number" name="phoneNumber"
                                           value="${sessionScope.user.phoneNumber}"/>
                                </div>
                                <button class="btn btn-primary " type="submit"></i> Update information
                                </button>
                            </form>
                        </div>
                    </div>
                    <c:if test="${requestScope.updateResult !=null}">
                        <br/>

                        <div class="alert alert-success">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Operation success!</strong> Personal information was changed.
                        </div>
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
