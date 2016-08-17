<!DOCTYPE html>
<%@ page import="entity.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>
<%@ page import="service.implementation.CardServiceImpl" %>
<%@ page import="service.CardService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="#b8860b">

<form id="do_payment" action="/do_payment" method="post">

    <lable>Sender:</lable>
    <br>

    <%
        CardService cardService = new CardServiceImpl();
        Long user_id = ((User) session.getAttribute("user")).getId();
        List<Card> cardList = cardService.getByUserId(Long.valueOf(user_id));
    %>
    <label>
        Select card
    </label>
    <br>
    <select name="sender_card_number">
        <%for (int i = 0; i < cardList.size(); i++) {%>
        <option>
            <%=cardList.get(i).getCardNumber()%>
        </option>
        <%}%>
    </select>
    <br>

    <label>
        Sum:
    </label>
    <br>
    <input name="sum" pattern="[0-9]*" border="10" required size="40" type="number"><br>

    <label>
        Title:
    </label>
    <br>
    <input name="title"  border="10" required size="40" type="text"><br><br>

    <label>Receiver: </label><br>
    <label>Card number: </label><br>
    <input name="receiver_card_number" pattern="[0-9]{16}" border="10" required size="40" type="number"><br>
    <input type="submit" value="Do payment" size="40"/>

</form>
</body>
</html>
