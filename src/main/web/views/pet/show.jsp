<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show Pet</title>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 style="text-align: center; margin-bottom: 40px">Добавление/Удалиение Животного</h1>
    <table border="1" class="table">
        <tr>
            <td>Имя</td>
            <td>Действие</td>
        </tr>
        <c:forEach items="${pets}" var="pet" varStatus="status">
            <tr>
                <td>${pet.id}</td>
                <td>${pet.petName}</td>
                <td>
                    <a href="/pet/delete?id=${pet.id}">
                        <input type="submit" value="Удалить" >
                    </a>
                    <a href="/pet/edit?id=${pet.id}">
                        <input type="submit" value="Редактировать">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

