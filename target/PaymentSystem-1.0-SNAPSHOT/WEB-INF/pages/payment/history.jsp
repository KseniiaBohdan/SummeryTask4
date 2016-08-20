<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="entity.Payment" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="service.PaymentService" %>
<%@ page import="service.implementation.PaymentServiceImpl" %>
<%@ page import="service.UserService" %>
<%@ page import="service.implementation.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="#ff7f50">
<%
    UserService userService = new UserServiceImpl();
    User user = (User) session.getAttribute("user");
    PaymentService paymentService = new PaymentServiceImpl();
    List<Payment> paymentSendList = paymentService.getByUserSenderId(user.getId());
    List<Payment> paymentReceiveList = paymentService.getByUserReceiverId(user.getId());
%>

<table bgcolor="#deb887" border="2" bordercolor="white">
    <tr>
        <td>Number</td>
        <td>From</td>
        <td>To</td>
        <td>Sum</td>
        <td>Date</td>
        <td>Title</td>
        <td>Status</td>
    </tr>
    <%for (int i = 0; i < paymentSendList.size(); i++) {%>
    <tr>
        <td><%=paymentSendList.get(i).getNumber()%>
        </td>
        <td>Card <%=paymentSendList.get(i).getGetCardNumberSender()%>
        </td>
        <td>
            <%
                Long cardNumber = paymentSendList.get(i).getCardNumberReceiver();
                User userReceiver = userService.getByCardNumber(cardNumber);
                String name = userReceiver.getFirstName() + " " + userReceiver.getSecondName() + " " + userReceiver.getPatronymic();
            %>
            <%=name%>
            Card <%=paymentSendList.get(i).getCardNumberReceiver()%>
        </td>
        <td><%=paymentSendList.get(i).getSum()%>
        </td>
        <td><%=paymentSendList.get(i).getTitle()%>
        </td>
        <td><%=paymentSendList.get(i).getDate()%>
        </td>
        <td><%=paymentSendList.get(i).getPaymentStatusId()%>
        </td>
    </tr>
    <%}%>
</table>
<br>
<br>
<%for (int i = 0; i < paymentReceiveList.size(); i++) {%>
<%=paymentReceiveList.get(i).getId()%>
<%=paymentReceiveList.get(i).getTitle()%>
<%=paymentReceiveList.get(i).getNumber()%>
<%=paymentReceiveList.get(i).getCardNumberReceiver()%>
<%=paymentReceiveList.get(i).getDate()%>
<%=paymentReceiveList.get(i).getGetCardNumberSender()%>
<%=paymentReceiveList.get(i).getSum()%>
<%=paymentReceiveList.get(i).getPaymentStatusId()%>
<br>
<%}%>
</body>
</html>