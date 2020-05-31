<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jimmim
  Date: 29.05.2020
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user</title>
</head>
<body>
    login: ${user.login}
    Password: ${user.password}
    email: ${user.email}
    <br>
    <a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
