<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show Role</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body style="background: url(/images/Cool-White-And-Blue-Background.jpg) no-repeat; background-size: 100%;">
<div class="container">
    <a href="/client/show" style="text-align: center; margin-bottom: 40px"><h1>Добавление/Удалиение Роли у клиента ${client.login}</h1></a>
    <table border="1" class="table">
        <tr>
            <td>Роли</td>
            <td>Действие</td>
        </tr>
            <tr>
                <td>${role.role}</td>
                <td>
                    <a href="/pet/delete?id=${role.id}">
                        <input type="submit" value="Удалить" class="btn btn-info btn-sm" >
                    </a>
                </td>
            </tr>
    </table>
    <form class="form-horizontal" action="/admin/change" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">Роль</label>
                <div class="col-sm-2">
                    <select name="idRole" id="idRole" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}">${role.role}</option>
                        </c:forEach>
                    </select>
                </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Изменить</button>
            </div>
        </div>
    </form>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-success" onclick="history.back();">Вернуться</button>
        </div>
    </div>


</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>