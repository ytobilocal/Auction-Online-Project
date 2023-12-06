<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <style>
              <%@include file="/resources/css/registration.css" %>
            </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/register" method="post" class="registration-box">
    <h1>Registration Form</h1>

    <div class="textbox">
        <i class="fas fa-envelope"></i>
        <label>Email: </label>
        <input type="text" name="email" required>
    </div>

    <div class="textbox">
        <i class="fas fa-user"></i>
        <label>Name: </label>
        <input type="text" name="name" required>
    </div>

    <div class="textbox">
        <i class="fas fa-lock"></i>
        <label>Password: </label>
        <input type="password" name="password" required>
    </div>

    <div class="textbox">
        <i class="fas fa-phone"></i>
        <label>Phone: </label>
        <input type="text" name="numPhone" required>
    </div>

<div class="radio-group">
    <label>Gender: </label>
    <input type="radio" name="gender" value="MALE" checked> Male
    <input type="radio" name="gender" value="FEMALE"> Female
    <input type="radio" name="gender" value="OTHER"> Other
</div>

    <button type="submit" class="btn">Register</button>
</form>

</body>
</html>
