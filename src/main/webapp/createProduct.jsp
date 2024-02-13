<%--
  Created by IntelliJ IDEA.
  User: HD
  Date: 11/02/2024
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sell</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h1>CREATE</h1>
    <div id="notification" style="display: none; color: green;">Product added successfully!</div>
    <% Boolean productAdded = (Boolean) request.getAttribute("productAdded"); %>
    <script>
        var productAdded = <%= productAdded %>;
        if (productAdded) {
            document.getElementById('notification').style.display = 'block';
        }
    </script>
    <form action="createProduct" method="post">
        <table>
            <tr>
                <td>Name of the product:</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>Description of the product:</td>
                <td>
                    <input type="text" name="description">
                </td>
            </tr>
            <tr>
                <td>Price of the product:</td>
                <td>
                    <input type="text" name="price">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Sell">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
