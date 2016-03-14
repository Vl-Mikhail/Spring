<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit Client</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body style="background: url(/images/Cool-White-And-Blue-Background.jpg) no-repeat; background-size: 100%;">
<div class="container">
    <h1 style="margin-bottom: 40px">Редактирование данных клиента</h1>
    <form class="form-horizontal" action="/client/edit" method="post">
        <div class="form-group">
            <label for="id" class="col-sm-2 control-label">Номер</label>
            <div class="col-sm-2">
                <input type="text" name="id" class="form-control" id="id" value="${client.id}">
            </div>
        </div>
        <div class="form-group">
            <label for="login" class="col-sm-2 control-label">Логин</label>
            <div class="col-sm-2">
                <input type="text" name="login" class="form-control" id="login" value="${client.login}">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Почта</label>
            <div class="col-sm-2">
                <input type="text" name="email" class="form-control" id="email" value="${client.email}">
            </div>
        </div>
        <div class="form-group">
        <label for="pw" class="col-sm-2 control-label">Пароль</label>
        <div class="col-sm-2">
            <input type="text" name="password" class="form-control" id="pw" value="${client.password}">
        </div>
    </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Изменить</button>
            </div>
        </div>
    </form>
</div>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
