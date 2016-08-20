<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="aqua">
<jsp:text>Registration</jsp:text>
<br>

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
</body>
</html>
