<%--
  Created by IntelliJ IDEA.
  User: Valdis003
  Date: 05.05.2017
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Main interface</title>
</head>
<body>
<form action="/yandex" method="post">
    <input type="text" name="text">
    <input type="submit">
</form>
<form action="/translate" method="post">
    <label>translation</label>
    <input type="text" name="text">
    <br>
    <input type="submit" name="submit">
</form>
<form action="/add_card" method="post">
    <label>word_Id</label>
    <input type="text" name="word_id">
    <br>
    <label>translation_id</label>
    <input type="text" name="translation_id">
    <br>
    <label>context</label>
    <input type="text" name="context">
    <br>
    <label>source</label>
    <input type="text" name="source">
    <br>
    <label>chosen_group_number</label>
    <input type="text" name="gnumber">
    <br>
    <input type="submit">
</form>
<a href="/close_session">Выход</a>
</body>
</html>
