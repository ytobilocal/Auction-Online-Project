<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Account</title>
</head>
<body>

    <h2>Edit Account</h2>

    <form action="updateAccount" method="post">
        <!-- Display current account details -->
        <label>ID:</label>
        <input type="text" name="id" value="${account.id}" readonly><br>

        <label>Email:</label>
        <input type="text" name="email" value="${account.email}" readonly><br>

        <!-- Add other fields as needed -->

        <!-- Submit button -->
        <input type="submit" value="Save Changes">
    </form>

</body>
</html>
