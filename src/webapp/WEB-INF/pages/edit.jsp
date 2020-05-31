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
    <title>edit</title>
</head>
<body>
<form action="/edit" method="post">
    login: <input type="text" name="login" value="${user.login}"/>
    Password: <input type="text" name="password" value="${user.password}"/>
    email: <input type="text" name="email" value="${user.email}"/>
    <br>
    <button type="submit" name="id" value="${user.id}">edit</button>
<%--    если из бутона ид не пройдет, то попробовать инпут --%>
</form>

</body>
</html>
