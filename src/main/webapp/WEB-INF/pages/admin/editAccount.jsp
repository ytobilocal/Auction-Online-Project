<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit Account</title>
    <jsp:include page="../include/css-page.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
    <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.getContextPath()}/resources/css/styleEditAccount.css">
</head>
<body>

    <div class="container">
        <h2>Edit Account</h2>

        <form action="${pageContext.request.contextPath}/admin/home/update/${account.id}" method="post">
            <!-- Display current account details -->
            <div class="form-group">
                <label>ID:</label>
                <span class="form-control">${account.id}</label>
            </div>

            <div class="form-group">
                <label>Email:${account.email}</label>
            </div>

            <!-- Display other fields as needed -->
            <div class="form-group">
                <label>Full Name:${account.fullName}</label>
            </div>

            <div class="form-group">
                <label>Phone:${account.phone}</label>
            </div>

            <div class="form-group">
                <label>Address:${account.address}</label>
            </div>

            <div class="form-group">
                <label>Roles:</label>
                <select name="selectedRole" multiple>
                    <c:forEach var="role" items="${availableRoles}">
                        <option value="${role.id}" ${account.userRoles.contains(role) ? 'selected' : ''}>${role.role}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- Remove the submit button if not needed -->
            <input type="submit" class="btn btn-primary" value="Save Changes">
        </form>
    </div>

</body>
</html>
