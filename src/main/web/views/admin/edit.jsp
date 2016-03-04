<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 04.03.2016
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <form method="post" action="/admin/edit" style="margin-top: 100px">
        <tr>
            <td>
                ID  <input type="text" name="id" value="${role.id}">
                Логин <input type="text" name="role" value="${role.role}">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Применить"/></td>
        </tr>
    </form>
</body>
</html>
