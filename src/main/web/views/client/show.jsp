<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body style="background: url(/images/Cool-White-And-Blue-Background.jpg) no-repeat; background-size: 100%;">
<div class="container">
    <a href="/client/show" style="text-align: center"> <h1>Клиника домашних животных</h1> </a>
    <table border="1" class="table">
        <tr>
            <td>Номер</td>
            <td>Логин</td>
            <td>Пароль</td>
            <td>Почта</td>
            <td>Роль</td>
            <td>Животное</td>
            <td>Сообщение</td>
            <td>Действия над Клиентом</td>
        </tr>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.login}</td>
                <td>${client.password}</td>
                <td>${client.email}</td>
                <td>${client.role.role}<br>
                    <a href="/admin/show?id=${client.id}">
                        <input type="submit" value="Change" class="btn btn-info btn-sm">
                    </a>
                </td>
                <td>
                <c:forEach items="${client.pets}" var="pet">
                    <c:out value="${pet.petName}"/>
                </c:forEach><br>
                    <a href="/pet/show?id=${client.id}">
                        <input type="submit" value="Add/Delete" class="btn btn-info btn-sm">
                    </a>
                </td>

                <td><c:forEach items="${client.messages}" var="message">
                    <c:out value="${message.text}"/>
                </c:forEach><br>
                    <a href="/message/show?id=${client.id}">
                        <input type="submit" value="Add/Delete" class="btn btn-info btn-sm">
                    </a>
                </td>
                <td style="vertical-align: bottom">
                    <a href="/client/delete?id=${client.id}">
                        <input type="submit" value="Удалить" class="btn btn-info btn-sm">
                    </a>
                    <a href="/client/edit?id=${client.id}">
                        <input type="submit" value="Редактировать" class="btn btn-info btn-sm">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form class="form-horizontal" action="/client/new" method="post">
        <div class="form-group">
            <label for="inputlogin" class="col-sm-2 control-label">Пользователь</label>
            <div class="col-sm-2">
                <input type="text" name="login" class="form-control"  id="inputlogin" placeholder="Пользователь" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputpw" class="col-sm-2 control-label">Пароль</label>

            <div class="col-sm-2">
                <input type="text" name="password" class="form-control"  id="inputpw" placeholder="Пароль" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">Почта</label>
            <div class="col-sm-2">
                <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Почта" required>
            </div>
        </div>
        <%--<div class="form-group">--%>
            <%--<label class="col-sm-2 control-label">Роль</label>--%>
            <%--<div class="col-sm-2">--%>
                <%--<select name="role.role" id="role" class="form-control">--%>
                    <%--<c:forEach items="${roles}" var="role">--%>
                        <%--<option value="${role.role}">${role.role}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Добавить Клиента</button>
            </div>
        </div>
    </form>


    <form class="form-inline" action="/find/client" method="get" style="margin-left: 70px">
        <div class="form-group">
            <label for="exampleInputName" style="margin-right: 30px">Имя клиента</label>
            <input type="text" class="form-control" id="exampleInputName" placeholder="Jane Doe" name="client">
        </div>
        <button type="submit" class="btn btn-success">Поиск</button>
    </form>

    <form class="form-inline" action="/find/pet" method="get"  style="margin-left: 44px">
        <div class="form-group">
            <label for="exampleInputName2" style="margin-right: 30px">Кличка питомца</label>
            <input type="text" class="form-control" id="exampleInputName2" placeholder="Кот Вася" name="pet">
        </div>
        <button type="submit" class="btn btn-success">Поиск</button>
    </form>

    <%--<a href="/j_spring_security_logout">Logout</a>--%>

</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
