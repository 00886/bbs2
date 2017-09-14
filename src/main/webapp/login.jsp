<%--
  Created by IntelliJ IDEA.
  User: swift
  Date: 2017/9/14
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action='<c:out value="login.html"/>'>
    <table>
        <tr>
            <td>用户名：</td><td><input type="text" name="user_name"></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp码：</td><td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>
</body>
</html>
