<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <a href="/client/show" style="text-align: center"> <h1>Клиника домашних животных</h1> </a>
    <table border="1" class="table">
        <tr>
            <td>Номер</td>
            <td>Логин</td>
            <td>Почта</td>
            <td>Животное</td>
            <td>Роль</td>
            <td>Действие</td>
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
                <td>
                    <a href="/client/delete?id=${client.id}">
                        <input type="submit" value="Удалить" >
                    </a>
                    <a href="/client/edit?id=${client.id}">
                        <input type="submit" value="Редактировать">
                    </a>
                    <a href="/client/pet?id=${client.id}">
                        <input type="submit" value="Животное">
                    </a>
                    <a href="/client/addmess?id=${client.id}">
                        <input type="submit" value="Сообщение">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <%--<form action="/client/new" method="post" style="margin-top: 20px" class="form-horizontal">--%>
    <form class="form-horizontal" action="/client/new" method="post">
        <div class="form-group">
            <label for="inputlogin" class="col-sm-2 control-label">Пользователь</label>
            <div class="col-sm-2">
                <input type="text" name="login" class="form-control"  id="inputlogin" placeholder="Пользователь">
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">Почта</label>
            <div class="col-sm-2">
                <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Почта">
            </div>
        </div>
        <div class="form-group">
            <label for="inputRole" class="col-sm-2 control-label">Роль</label>
            <div class="col-sm-2">
                <input type="text" name="role" class="form-control" id="inputRole" placeholder="Роль">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPet" class="col-sm-2 control-label">Животное</label>
            <div class="col-sm-2">
                <input type="text" name="pet" class="form-control" id="inputPet" placeholder="Животное">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Добавить Клиента</button>
            </div>
        </div>
    </form>

    <form class="form-horizontal" action="/client/find" method="get">
        <div class="form-group">
            <label for="find" class="col-sm-2 control-label">Имя Клиента</label>
            <div class="col-sm-2">
                <input type="text" name="findName" class="form-control"  id="find" placeholder="Имя Клиента">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Поиск</button>
            </div>
        </div>
    </form>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
