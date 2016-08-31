<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Admin profile</title>
    <%@ include file="/WEB-INF/pages/fragment/styles.jspf" %>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/pages/fragment/adminMenu.jspf" %>
    <div id="page-wrapper">
        <nav id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>Admin profile</h2>
                    <h5>
                        Welcome, ${sessionScope.user.firstName} ${sessionScope.user.secondName} ${sessionScope.user.patronymic}. </h5>
                </div>
            </div>

            <div class="row">
                <div class="col-md-9 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Admin profile
                        </div>
                        <div class="panel-body">

                        </div>
                    </div>

                </div>
            </div>
        </nav>
    </div>
</div>
</div>
<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf" %>
</body>
</html>
