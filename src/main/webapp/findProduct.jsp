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
<script>
    function callServlet(index) {
        fetch('buyProduct?index=' + index, {
            method: 'GET',
        })
            .then(response => response.text())
            .then(data => {
                console.log(data);
                // Handle the response data here
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
</script>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
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
<c:if test="${not empty requestScope.productList}">
    <h2>Product Details</h2>
    <form action="buyProduct" method="post">
        <table border="1">
            <c:forEach var="product" items="${requestScope.productList}" varStatus="loop">
                <tr>
                    <td>Name: ${product.name}</td> <!-- change here -->
                    <td>Description: ${product.description}</td> <!-- change here -->
                    <td>Price: ${product.price}</td> <!-- change here -->
                    <td><button  onclick="callServlet(${product.id})" type="submit" value="buy">Buy</button> <!-- change here --> </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</c:if>
</body>
</html>
