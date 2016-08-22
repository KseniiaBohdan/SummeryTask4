<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="entity.Payment" %>
<%@ page import="entity.User" %>
<%@ page import="service.PaymentService" %>
<%@ page import="service.implementation.PaymentServiceImpl" %>
<%@ page import="service.UserService" %>
<%@ page import="service.implementation.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body bgcolor="#ff7f50">
<%
    UserService userService = new UserServiceImpl();
    User user = (User) session.getAttribute("user");
    PaymentService paymentService = new PaymentServiceImpl();
    List<Payment> paymentList = paymentService.getByUserSenderId(user.getId());
    paymentList.addAll(paymentService.getByUserReceiverId(user.getId()));
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
    <%for (int i = 0; i < paymentList.size(); i++) {%>
    <tr>
        <td><%=paymentList.get(i).getNumber()%>
        </td>
        <td>Card <%=paymentList.get(i).getGetCardNumberSender()%>
        </td>
        <td>
            <%
                Long cardNumber = paymentList.get(i).getCardNumberReceiver();
                User userReceiver = userService.getByCardNumber(cardNumber);
                String name = userReceiver.getFirstName() + " " + userReceiver.getSecondName() + " " + userReceiver.getPatronymic();
            %>
            <%=name%>
            Card <%=paymentList.get(i).getCardNumberReceiver()%>
        </td>
        <td><%=paymentList.get(i).getSum()%>
        </td>
        <td><%=paymentList.get(i).getTitle()%>
        </td>
        <td><%=paymentList.get(i).getDate()%>
        </td>
        <td><%=paymentList.get(i).getPaymentStatusId()%>
        </td>
    </tr>
    <%}%>
</table>
<br>
<br>

</body>
</html>