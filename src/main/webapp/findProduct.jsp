<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: HD
  Date: 17/02/2024
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Find Product</h1>
    <form action="findProduct" method="post">
        <table border="1">
            <tr>
                <td>Name:<label>
                    <input type="text" name="name" />
                </label></td>
                <td>Description:<label>
                    <input type="text" name="description" />
                </label></td>
                <td>Price:<label>
                    <input type="text" name="price" />
                </label></td>
                <td><input type="submit" value="Find"></td>
            </tr>
        </table>
    </form>

    <%--<c:if test="${not empty requestScope.foundProduct}">
        <h2>Product Details</h2>
        <table border="1">
            <tr>
                <td>Id: ${requestScope.foundProduct.id}</td>
                <td>Name: ${requestScope.foundProduct.name}</td>
                <td>Description: ${requestScope.foundProduct.description}</td>
                <td>Price: ${requestScope.foundProduct.price}</td>
            </tr>
        </table>
    </c:if>--%>

    <c:if test="${not empty requestScope.productList}">
        <h2>Product Details</h2>
        <table border="1">
            <c:forEach var="product" items="${requestScope.productList}" >
                <tr>
                    <td>Name: ${product.name}</td> <!-- change here -->
                    <td>Description: ${product.description}</td> <!-- change here -->
                    <td>Price: ${product.price}</td> <!-- change here -->
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
