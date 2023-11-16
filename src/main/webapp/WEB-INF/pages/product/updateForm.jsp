<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
</head>
<body>
    <h2>Update Product</h2>
    <form action="${pageContext.request.contextPath}/user/update" method="post">
        <input type="hidden" name="productId" value="${product.productId}" />
        <label>Product Name: <input type="text" name="productName" value="${product.productName}" /></label><br/>
        <label>Description: <input type="text" name="description" value="${product.description}" /></label><br/>
        <button type="submit">Update Product</button>
    </form>
</body>
</html>
