<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>
<%@ page import="entity.Account" %>
<%@ page import="service.AccountService" %>
<%@ page import="service.implementation.AccountServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body bgcolor="#d2691e">
<jsp:text>Delete account</jsp:text>
<br>

<form id="delete-account" action="/delete_account" method="post">

  <%
    AccountService accountService = new AccountServiceImpl();
    Long user_id = ((User)session.getAttribute("user")).getId();
    List<Account> accountList = accountService.getByUserId(Long.valueOf(user_id));
  %>
  <label>
    Select account:
  </label>
  <br>
  <select name = "account_id">
    <%for (int i = 0; i < accountList.size(); i++) {%>
    <option>
      <%=accountList.get(i).getId()%>
    </option>
    <%}%>
  </select>
  <br>
  <input type="submit" value="Delete account" size="40"/>

</form>
</body>
</html>
