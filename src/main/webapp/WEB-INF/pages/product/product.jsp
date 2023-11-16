<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>How to fetch image from the database using Spring MVC</h2>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Photo</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${listPro}">
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.description}</td>
                <td><img width="100" height="100" src="getProductPhoto/${product.productId}"></td>
                <td>
                    <a href="update/${product.productId}">Update</a>
                    |
                    <a href="delete/${product.productId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
