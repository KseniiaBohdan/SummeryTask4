<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h5>
    <fmt:message key="welcome"/>, ${requestScope.userModel.user.firstName} ${requestScope.userModel.user.secondName} ${requestScope.userModel.user.patronymic}.
    <br/></h5>
<c:if test="${sessionScope.user.status.toString()=='BLOCKED'}">
    <h5 style="color: red"><fmt:message key="sorry_but_your_profile_is_blocked"/></h5>
</c:if>