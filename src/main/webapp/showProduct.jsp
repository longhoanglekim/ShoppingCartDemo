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
    <title>show</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Product List</h1>

<form>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <!-- Add more columns if needed -->
        </tr>
        <c:set var="products" value="${sessionScope.products}"/>
        <!-- Iterate over the list of products using JSTL forEach -->
        <c:forEach var="product" items="${products}">
            <tr>
<%--                <button type="submit" name="productButton" form="productAction" value="${product.id}">View</button>--%>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>
                    <form id="productAction" action="watchProduct" method="get">
                        <button type="submit" name="productButton" form="productAction" value="${product.id}">View</button>
                    </form>
                </td>
                <!-- Add more columns if needed -->
            </tr>

        </c:forEach>
    </table>
</form>

<form id="createProductAction" action="createProduct" method="get">
    <button type="submit" name="createButton" form="createProductAction">Sell your product</button>
</form>

</body>
</html>
