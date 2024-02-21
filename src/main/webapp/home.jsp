<%--
  Created by IntelliJ IDEA.
  User: HD
  Date: 09/02/2024
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <c:set var="userName" value="${sessionScope.userName}" />
    <h1>Welcome to Charlotte,${userName}</h1>
</body>
</html>
