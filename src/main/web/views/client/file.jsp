
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File</title>
</head>
<body>
<div align="center">
    <h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
    <form method="post" action="/image/upload" enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>Pick file #1:</td>
                <td><input type="file" name="file" size="50" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
