<%@ page import="service.UserService" %>
<%@ page import="service.implementation.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    UserService userService = new UserServiceImpl();
    List<User> userList = userService.getAll();
%>

<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Status</td>
        <td>Do</td>
    </tr>
    <tr>
        <%for(int i=0; i<userList.size(); i++){%>
        <td><%=userList.get(i).getId()%></td>
        <td><%=userList.get(i).getFirstName()%></td>
        <td><%=userList.get(i).getStatus()%></td>
        <td>
            <form id="Delete user" action="/user_managment" method="post">
            </form>
        </td>
        <%}%>
    </tr>
</table>

</body>
</html>
