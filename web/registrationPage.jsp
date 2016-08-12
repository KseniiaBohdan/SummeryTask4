<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="green">
<jsp:text>Registration</jsp:text><br>
<form id="registration_user" action="/result" method="post">
    <table>
        <tr>
            <td>
                <jsp:text> Input your email:</jsp:text>
                <br>
                <input type="email" align="right" border="10" required size="40" name="email"><br>

                <jsp:text> Input your password:</jsp:text>
                <br>
                <input type="password" align="right" border="10" required size="40" name="password"><br>

                <jsp:text> Repeat password:</jsp:text>
                <br>
                <input type="password" align="right" border="10" required size="40" name="repeat_password"><br>

                <jsp:text> Input your first_name:</jsp:text>
                <br>
                <input type="text" align="right" border="10" required size="40" name="first_name"><br>

                <jsp:text> Input your second_name:</jsp:text>
                <br>
                <input type="text" align="right" border="10" required size="40" name="second_name"><br>

                <jsp:text> Input your patronymic:</jsp:text>
                <br>
                <input type="text" align="right" border="10" required size="40" name="patronymic"><br>

                <jsp:text> Input your phone_number:</jsp:text>
                <br>
                <input type="text" align="right" border="10" required size="40" name="phone_number"><br>
                </input>
            </td>
            <td>
                <jsp:text> Input your card number:</jsp:text>
                <br>
                <input type="number" align="right" border="10" required size="40" name="card_number"><br>

                <jsp:text> Input card expire date:</jsp:text>
                <br>
                <input type="date" align="right" border="10" required size="40" name="expire_date"><br>

                <jsp:text> Pin:</jsp:text>
                <br>
                <input type="password" align="right" border="10" required size="40" name="pin"><br>

                <jsp:text> Repeat pin:</jsp:text>
                <br>
                <input type="password" align="right" border="10" required size="40" name="repeat_pin"><br>

                <jsp:text> Title for card:</jsp:text>
                <br>
                <input type="text" align="right" border="10" size="40" name="card_title"/><br>
            </td>
            <td>
                <jsp:text> Input your account number:</jsp:text>
                <br>
                <input type="number" align="right" border="10" required size="40" name="account_id"><br>

                <jsp:text> Input your account balance:</jsp:text>
                <br>
                <input type="number" align="right" border="10" required size="40" name="balance"><br>

                <jsp:text> Title for account:</jsp:text>
                <br>
                <input type="text" align="right" border="10" size="40" name="account_title"><br>

                <input type="submit" value="Registrate" size="40"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
