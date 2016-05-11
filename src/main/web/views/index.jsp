<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home Page</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

</head>
<body style="background: url(/images/Cool-White-And-Blue-Background.jpg) no-repeat; background-size: 100%;">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Клиника домашних животных</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="#">Услуги</a></li>
            <li><a href="#">О нас</a></li>
        </ul>
    </div>
</nav>
<div class="container" style="padding-top: 30px">
    <table border="1" class="table table-striped">
        <tr>
            <td>Номер</td>
            <td>Логин</td>
            <td>Почта</td>
            <td>Животное</td>
            <td>Фотография</td>
        </tr>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.login}</td>
                <td>${client.email}</td>
                <td><c:forEach items="${client.pets}" var="pet">
                    <c:out value="${pet.petName}"/>
                </c:forEach></td>
                <td><img src="<c:url value="/image/display?id=${client.id}"/>" style="width: 60px; height: 60px"></td>
            </tr>
        </c:forEach>
    </table>
<a href="/login" style="text-decoration: none; text-align: center"> <h4>Войти</h4> </a>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
