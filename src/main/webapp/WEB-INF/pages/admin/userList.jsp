<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account List</title>
    <style>
              <%@include file="/resources/css/list.css" %>
            </style>
</head>
<body>

    <h2>Account List</h2>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Status</th>
                <th>Roles</th>
                <th>Gender</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${accountList}">
                <tr>
                    <td>${account.id}</td>
                    <td>${account.email}</td>
                    <td>${account.name}</td>
                    <td>${account.phone}</td>
                    <td>${account.status}</td>
                    <td>
                        <c:forEach var="role" items="${account.userRoles}">
                            ${role.role}<br>
                        </c:forEach>
                    </td>
                    <td>${account.gender}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
