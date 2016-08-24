<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/styles/css/normalize.css" media="screen" type="text/css">
    <link rel="stylesheet" href="/styles/css/style.css" media="screen" type="text/css">
</head>
<body>
<form id="registration_user" action="/registration" method="post">
<table>
<tr>
<td>
<jsp:text> Input your email:</jsp:text>
<br>
<input type="email" align="right" border="10" required size="40" name="email"
pattern=".*@[A-Za-z0-9]*.[A-Za-z0-9]*"><br>

<jsp:text> Input your password:</jsp:text>
<br>
<input type="password" align="right" border="10" required size="40" name="password"
pattern="[A-Za-z0-9]*"><br>

<jsp:text> Repeat password:</jsp:text>
<br>
<input type="password" align="right" border="10" required size="40" name="repeat_password"
pattern="[A-Za-z0-9]*"><br>

<jsp:text> Input your first_name:</jsp:text>
<br>
<input type="text" align="right" border="10" required size="40" name="first_name"
pattern="[A-ZА-Я][a-zа-я]*"><br>

<jsp:text> Input your second_name:</jsp:text>
<br>
<input type="text" align="right" border="10" required size="40" name="second_name"
pattern="[A-ZА-Я][a-zа-я]*"><br>

<jsp:text> Input your patronymic:</jsp:text>
<br>
<input type="text" align="right" border="10" required size="40" name="patronymic"
pattern="[A-ZА-Я][a-zа-я]*"><br>

<jsp:text> Input your phone_number:</jsp:text>
<br>
<input type="text" align="right" border="10" required size="40" name="phone_number"
pattern="\+[0-9]{12}"><br>
</input>
</td>
<td>
<jsp:text> Input your card number:</jsp:text>
<br>
<input type="number" align="right" border="10" required size="40" name="card_number"
pattern="[0-9]{16}"><br>

<jsp:text> Input card expire date:</jsp:text>
<br>
<input type="date" align="right" border="10" required size="40" name="expire_date"><br>

<jsp:text> Pin:</jsp:text>
<br>
<input type="password" align="right" border="10" required size="40" name="pin"
pattern="[0-9]{4}"><br>

<jsp:text> Repeat pin:</jsp:text>
<br>
<input type="password" align="right" border="10" required size="40" name="repeat_pin"
pattern="[0-9]{4}"><br>

<jsp:text> Title for card:</jsp:text>
<br>
<input type="text" align="right" border="10" size="40" name="card_title"/><br>
</td>
<td>
<jsp:text> Input your account number:</jsp:text>
<br>
<input type="number" align="right" border="10" required size="40" name="account_id"
pattern="[0-9]{16}"><br>

<jsp:text> Input your account balance:</jsp:text>
<br>
<input type="number" align="right" border="10" required size="40" name="balance"
pattern="[0-9]*\.[0-9]{2}"><br>

<jsp:text> Title for account:</jsp:text>
<br>
<input type="text" align="right" border="10" size="40" name="account_title"><br>

<input type="submit" value="Registrate" size="40"/>
</td>
</tr>
</table>
</form>

<%--<div class="form">--%>

    <%--<ul class="tab-group">--%>
        <%--<li class="tab active"><a href="#">Register</a></li>--%>
        <%--<li class="tab"><a href="/login">Log In</a></li>--%>
    <%--</ul>--%>

    <%--<div class="tab-content">--%>
        <%--<div id="signup">--%>
            <%--<h1>Register for Free</h1>--%>
            <%--<form action="/" method="post">--%>
                <%--<div class="top-row">--%>
                    <%--<div class="field-wrap">--%>
                        <%--<label>--%>
                            <%--First Name<span class="req">*</span>--%>
                        <%--</label>--%>
                        <%--<input type="text" required autocomplete="off"/>--%>
                    <%--</div>--%>
                    <%--<div class="field-wrap">--%>
                        <%--<label>--%>
                            <%--Last Name<span class="req">*</span>--%>
                        <%--</label>--%>
                        <%--<input type="text" required autocomplete="off"/>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="field-wrap">--%>
                    <%--<label>--%>
                        <%--Email Address<span class="req">*</span>--%>
                    <%--</label>--%>
                    <%--<input type="email" required autocomplete="off"/>--%>
                <%--</div>--%>

                <%--<div class="field-wrap">--%>
                    <%--<label>--%>
                        <%--Set A Password<span class="req">*</span>--%>
                    <%--</label>--%>
                    <%--<input type="password" required autocomplete="off"/>--%>
                <%--</div>--%>

                <%--<button type="submit" class="button button-block"/>--%>
                <%--Get Started</button>--%>

            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<!-- tab-content -->--%>

<%--</div>--%>
<%--<!-- /form -->--%>
<%--<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>--%>
<%--<script src="/styles/js/index.js"></script>--%>

</body>
</html>