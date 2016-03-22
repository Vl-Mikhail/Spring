<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show Pet</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body style="background: url(/images/Cool-White-And-Blue-Background.jpg) no-repeat; background-size: 100%;">
<div class="container">
    <h1 style="text-align: center; margin-bottom: 40px">Добавление/Удалиение Животного у клиента ${client.login}</h1>
    <table border="1" class="table">
        <tr>
            <td>Имя</td>
            <td>Возраст</td>
            <td>Действие</td>
        </tr>
        <c:forEach items="${pets}" var="pet" varStatus="status">
            <tr>
                <td>${pet.petName}</td>
                <td>${pet.age}</td>
                <td>
                    <a href="/pet/delete?id=${pet.id}">
                        <input type="submit" value="Удалить" class="btn btn-info btn-sm" >
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form class="form-horizontal" action="/pet/new" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Имя Животного</label>
            <div class="col-sm-2">
                <input type="text" name="petName" class="form-control"  id="name" placeholder="Имя Животного">
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">Возраст</label>
            <div class="col-sm-2">
                <input type="text" name="age" class="form-control"  id="age" placeholder="Возраст">
            </div>
        </div>
        <div>
            <div class="col-sm-2">
                <input type="hidden" name="${id}" placeholder="Имя Клиента">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Добавить нового питомца</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-success" onclick="history.back();">Вернуться</button>
            </div>
        </div>
    </form>


</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

