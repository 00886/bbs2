<%--
  Created by IntelliJ IDEA.
  User: swift
  Date: 2017/9/15
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form:form  method="post" commandName="user" >
    用户名：<form:input path="user_name"  />
    密&nbsp;&nbsp;&nbsp;码：<form:input path="password" />
    <%--确认密码：<form:input path="confirm_password" />--%>
    <form:button value="提交"/>
</form:form>
</body>
</html>
