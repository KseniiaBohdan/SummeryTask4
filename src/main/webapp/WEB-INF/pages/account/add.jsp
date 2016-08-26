<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add account</title>
</head>
<body bgcolor="#deb887">

<ul class="main-menu">
    <li><a>Card management</a>
        <ul class="sub-menu">
            <li><a href="/card/add">Add new card</a></li>
            <li><a href="/card/delete">Delete card</a></li>
            <li><a href="/card/block">Block card</a></li>
        </ul>
    </li>
    <li><a>Account management</a>
        <ul class="sub-menu">
            <li><a href="/account/add">Add new account</a></li>
            <li><a href="/account/delete">Delete account</a></li>
            <li><a href="/account/block">Block account</a></li>
        </ul>
    </li>
    <li><a href="/do-payment">Do payment</a></li>
    <li><a href="/history">Show history</a></li>
</ul>

Add new account <br>

<form id="add account" action="/account/add" method="post">
    Input account number: <br>
    <input type="number" align="right" border="10" required size="40" name="id" pattern="[0-9]{16}"><br>

    Title for account: <br>
    <input type="text" align="right" border="10" size="40" name="title"/><br>

    <input type="submit" value="Add account" size="40"/>

</form>
</body>
</html>
