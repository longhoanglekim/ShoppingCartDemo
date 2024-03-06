<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HD
  Date: 18/02/2024
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <h1>Order</h1>
    <c:forEach items="${sessionScope.orderProducts}" var="order">
        <p>${order.id} - ${order.name} - ${order.price}</p>
    </c:forEach>
</body>
</html>
