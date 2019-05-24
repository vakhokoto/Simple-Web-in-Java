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
    <h1>User name or password is missing</h1>
    <form action = "login" method = "post">
        User name: <input type = "text" name = "username" maxlength="50"><br>
        Password: <input type = "password" name = "password" maxlength="50"><br>
        <button type = "submit">Log in</button>
    </form>
    <form action = "CreateAccountServlet" method = "get">
        <a href = "createAccount">
            Create new account
        </a>
    </form>
</body>
</html>