<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Roles</title>
</head>
<body>
<div>
    <table border="1" style="margin-bottom: 10px; text-align: center">
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
    <form action="${pageContext.request.contextPath}/admin/new" method="post">
        Имя <input type="text" name="role">
        <input type="submit" align="center" value="Submit">
    </form>
</div>
</body>
</html>
