<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<div class="container">
    <a href="/client/show"> <h1>Клиника домашних животных</h1> </a>
    <table border="1" class="border">
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

    <form action="/client/new" method="post" style="margin-top: 20px">
        <tr>
            <td colspan="2">
                Логин <input type="text" name="login">
                Почта <input type="text" name="email">
                Роль <input type="text" name="role">
                <%--<input name="pet" type="text" id="pets" value="Животное" style="width: 100px">--%>
            </td>
            <td>
                <input type="submit" value="Добавить" style="width: 100px" onclick="return createUser();">
            </td>
        </tr>
    </form>
    <form action="/find" method="get" style="margin-top: 20px">
        <tr>
            <td><input name="login" type="text" value="Поиск по Имени" style="width: 200px"></td>
            <td><input type="submit" value="Выбрать" style="width: 100px"></td>
        </tr>
    </form>
</div>
</body>
</html>
