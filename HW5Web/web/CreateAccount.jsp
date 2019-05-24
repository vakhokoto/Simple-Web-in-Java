<%--
  Created by IntelliJ IDEA.
  User: vakhokoto
  Date: 5/18/19
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome to homework 5!</h1>
<form action = "createAccount" method = "post">
    User name: <input type = "text" name = "username" maxlength="50"><br>
    Password: <input type = "password" name = "password" maxlength="50"><br>
    <button type = "submit">Register</button>
</form>
</body>
</html>