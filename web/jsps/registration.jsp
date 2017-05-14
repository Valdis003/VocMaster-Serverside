<%--
  Created by IntelliJ IDEA.
  User: Valdis003
  Date: 14.05.2017
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">
    <label>login</label>
    <input type="text" name="login">
    <br>
    <label>password</label>
    <input type="password" name="password">
    <br>
    <label>repeat password</label>
    <input type="password" name="password_repeat">
    <br>
    <label>email</label>
    <input type="text" name="email">
    <br>
    <input type="submit">
</form>
</body>
</html>
