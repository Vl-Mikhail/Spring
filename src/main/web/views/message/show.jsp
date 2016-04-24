<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show Messages</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body style="background: url(/images/Cool-White-And-Blue-Background.jpg) no-repeat; background-size: 100%;">
<div class="container">
    <a href="/client/show" style="text-align: center; margin-bottom: 40px"><h1>Добавление/Удалиение Сообщение у клиента ${client.login}</h1></a>
    <table border="1" class="table">
        <tr>
            <td>Сообщение</td>
            <td>Действие</td>
        </tr>
        <c:forEach items="${messages}" var="message" varStatus="status">
            <tr>
                <td>${message.text}</td>
                <td>
                    <a href="/message/delete?id=${message.id}">
                        <input type="submit" value="Удалить" class="btn btn-info btn-sm" >
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form class="form-horizontal" action="/message/new" method="post">
        <div class="form-group">
            <label for="message" class="col-sm-2 control-label">Сообщение</label>
            <div class="col-sm-2">
                <textarea rows="5" cols="45" name="text" class="form-control"  id="message"></textarea>

            </div>
        </div>
        <div>
            <div class="col-sm-2">
                <input type="hidden" name="${client.id}" placeholder="Имя Клиента">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Добавить сообщение</button>
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
