<!DOCTYPE html>
<%@ page import="service.UserService" %>
<%@ page import="service.implementation.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="service.CardService" %>
<%@ page import="service.implementation.CardServiceImpl" %>
<%@ page import="entity.Card" %>
<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body bgcolor="green">
<jsp:text>Block card</jsp:text>
<br>

<form id="block-card" action="/block_card" method="post">

  <%
    CardService cardService = new CardServiceImpl();
    UserService userService = new UserServiceImpl();
    Long user_id = ((User)session.getAttribute("user")).getId();
    List<Card> cardList = cardService.getByUserId(Long.valueOf(user_id));
    for (int i = 0; i <cardList.size() ; i++) {
      if(cardList.get(i).getStatusId()==2){
        cardList.remove(i);
      }
    }
  %>
  <label>
    Select card
  </label>
  <br>
  <select name = "card_number">
    <%for (int i = 0; i < cardList.size(); i++) {%>
    <option>
      <%=cardList.get(i).getCardNumber()%>
    </option>
    <%}%>
  </select>
  <br>
  <input type="submit" value="Block card" size="40"/>

</form>
</body>
</html>

