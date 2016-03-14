<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Roles</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

</head>
<body style="background: url(/images/Cool-White-And-Blue-Background.jpg) no-repeat; background-size: 100%;">
<div class="container">
    <h1 style="text-align: center; margin-bottom: 40px">Колонка Админа</h1>
    <table border="1" class="table">
        <tr>
            <td>Имя</td>
            <td>Действие</td>
        </tr>
        <c:forEach items="${roles}" var="role" varStatus="status">
            <tr>
                <td width="100px">${role.role}</td>
                <td>
                <a href="/admin/delete?id=${role.id}">
                    <input type="submit" value="Удалить" >
                </a>
                <a href="/admin/edit?id=${role.id}">
                    <input type="submit" value="Редактировать">
                </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="/admin/text" method="get" class="form-horizontal">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-info">Список пользователей</button>
            </div>
        </div>
    </form>
    <form class="form-horizontal" action="/admin/new" method="post">
        <div class="form-group">
            <label for="role" class="col-sm-2 control-label">Роль</label>
            <div class="col-sm-2">
                <input type="text" name="pet" class="form-control" id="role" placeholder="Роль">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Добавить Роль</button>
            </div>
        </div>
    </form>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
