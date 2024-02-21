<%--
  Created by IntelliJ IDEA.
  User: HD
  Date: 09/02/2024
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <form action="login" method="post"/>--%>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Login</h1>
<form action="login" method="post">
    <p>Email:</p>
    <input type="text" name="email">
    <p>Password:</p>
    <label>
        <input type="password" name="password">
    </label><br/>
    <input type="submit" value="Login">
</form>
</body>
</html>
