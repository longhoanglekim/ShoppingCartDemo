<%--
  Created by IntelliJ IDEA.
  User: HD
  Date: 09/02/2024
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Charlotte</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h1>Welcome to Charlotte</h1>
    <form action="showProduct" method="post">
        <!-- You can add any additional input fields if needed -->
        <input type="submit" value="Show Products">
    </form>
</body>
</html>
