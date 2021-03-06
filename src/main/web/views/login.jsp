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
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/loginCSS.css"/>" rel="stylesheet">
</head>

<body style="background: url(/images/Cool-White-And-Blue-Background.jpg) no-repeat; background-size: 100%;">
<div class="container">
    <div class="col-sm-7">
        <h1 class="header">Авторизация</h1>

        <%--<c:url value="/j_spring_security_check" var="loginUrl" />--%>
        <form class="form-horizontal" action="<c:url value="/j_spring_security_check"/>" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Пользователь</label>
                <div class="col-sm-5">
                    <input type="text" name="username" class="form-control"  id="username" placeholder="Пользователь">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Пароль</label>
                <div class="col-sm-5">
                    <input type="password" name="password" class="form-control" id="password" placeholder="Пароль">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" name="submit" class="btn btn-success">Войти</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
