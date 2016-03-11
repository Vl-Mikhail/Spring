<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Roles</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

</head>
<body>
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
    <form action="/admin/text" method="get">
        <input type="submit" value="Результат">
    </form>
    <form action="${pageContext.request.contextPath}/admin/new" method="post">
        Имя <input type="text" name="role">
            <input type="submit" align="center" value="Submit">
    </form>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
