<!DOCTYPE html>
<%@ page import="service.AccountService" %>
<%@ page import="service.implementation.AccountServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Account" %>
<%@ page import="entity.User" %>
<%@ page import="entity.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body bgcolor="#5f9ea0">
<jsp:text>Block account</jsp:text>
<br>

<form id="block account" action="/account/block" method="post">

  <%
    AccountService accountService = new AccountServiceImpl();
    Long userId = ((User)session.getAttribute("user")).getId();
    List<Account> accountList = accountService.getByUserId(Long.valueOf(userId));
    for (int i = 0; i < accountList.size() ; i++) {
      if(accountList.get(i).getStatusId()== Status.BLOCKED.ordinal()+1){
        accountList.remove(i);
      }
    }
  %>
  <label>
    Select account:
  </label>
  <br>
  <select name = "account id">
    <%for (int i = 0; i < accountList.size(); i++) {%>
    <option>
      <%=accountList.get(i).getId()%>
    </option>
    <%}%>
  </select>
  <br>
  <input type="submit" value="Block account" size="40"/>

</form>
</body>
</html>

