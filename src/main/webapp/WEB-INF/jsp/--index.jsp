<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Авторизация</title>
</head>

<h1>Авторизация</h1>

<form method="post">
    <table style="width: 50%">
        <tr>
            <input type="text" name ="username" name="логин" placeholder="логин"/>
        </tr>
        <tr>
            <input type="password" name = "password" name="пароль" placeholder="пароль"/>
        </tr>
        <tr>
            <input type="submit"/>
        </tr>
    </table>
</form>
</html>