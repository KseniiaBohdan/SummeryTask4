<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register/Login</title>
    <link href="<c:url value="/styles/css/normalize.css" />" rel="stylesheet">
    <link href="<c:url value="/styles/css/style.css" />" rel="stylesheet">
</head>
<body>
<%--<form id="login" action="/profile" method="GET">--%>
    <%--<jsp:text> Email</jsp:text>--%>
    <%--<br>--%>
    <%--<input type="text" align="left" border="10" required size="40" name="email"--%>
           <%--pattern=".*@[A-Za-z0-9]*.[A-Za-z0-9]*"><br><br>--%>
    <%--<jsp:text> Password</jsp:text>--%>
    <%--<br>--%>
    <%--<input type="password" align="right" border="10" required size="40" name="password" pattern="[a-zA-Z0-9]*"><br><br>--%>
    <%--<input type="submit" value="Login" size="40"/><br><br>--%>
    <%--</input>--%>
<%--</form>--%>
<%--<form id="registration" action="/registration" method="GET">--%>
    <%--<input type="submit" value="Registration" size="40"/>--%>
<%--</form>--%>
<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="/registration">Register</a></li>
        <li class="tab"><a href="#">Log In</a></li>
    </ul>

    <div class="tab-content">
        <div id="login">
            <h1>Welcome Back!</h1>
            <form action="/" method="post">
                <div class="field-wrap">
                    <label>
                        Email Address<span class="req">*</span>
                    </label>
                    <input type="email"required autocomplete="off"/>
                </div>
                <div class="field-wrap">
                    <label>
                        Password<span class="req">*</span>
                    </label>
                    <input type="password"required autocomplete="off"/>
                </div>
                <p class="forgot"><a href="#">Forgot Password?</a></p>
                <button class="button button-block"/>Log In</button>
            </form>
        </div>
    </div><!-- tab-content -->

</div> <!-- /form -->
<script src="<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />"></script>
<script src="<c:url value="/styles/js/index.js" />"></script>

</body>
</html>

