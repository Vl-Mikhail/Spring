<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home Page</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

</head>
<body style="background: url(/images/free-background-backgrounds-widescreen.png) no-repeat; background-size: 100%;">
<div class="container">
<a href="/" style="text-align: center"> <h1>Клиника домашних животных</h1> </a>
    <table border="1" class="table table-striped">
        <tr>
            <td>Номер</td>
            <td>Логин</td>
            <td>Почта</td>
            <td>Животное</td>
            <td>Роль</td>
        </tr>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.login}</td>
                <td>${client.email}</td>
                <td><c:forEach items="${client.pets}" var="pet">
                    <c:out value="${pet.petName}"/>
                </c:forEach></td>
                <td>${client.role.role}</td>
            </tr>
        </c:forEach>
    </table>
<a href="/login" style="text-decoration: none; text-align: center"> <h4>Войти</h4> </a>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
