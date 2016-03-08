<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 08.03.2016
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Главная стараница</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>
<div class="block">
    <form action="/client/show">
        <label for="client">Пользователь</label>
        <input type="text" tabindex="1" name="login" placeholder="имя" id="client" required>
        <label for="pw">Пароль</label>
        <input type="password" tabindex="2" name="password" id="pw" placeholder="пароль" required>
        <input type="submit" value="Login" tabindex="3">
    </form>
</div>

</body>
</html>
