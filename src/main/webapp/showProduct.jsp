<%@ page import="com.longhlk.trainings.websource.models.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HD
  Date: 10/02/2024
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Charlotte</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Product List</h1>

<form>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <!-- Add more columns if needed -->
        </tr>
        <c:set var="products" value="${requestScope.products}" />
        <!-- Iterate over the list of products using JSTL forEach -->
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <!-- Add more columns if needed -->
            </tr>
        </c:forEach>
    </table>
</form>
<br/>
<form id="createProductAction" action="createProduct" method="post" >
    <button type="submit" name="createButton" form="createProductAction" value="Create product">Create</button>
</form>

</body>
</html>
