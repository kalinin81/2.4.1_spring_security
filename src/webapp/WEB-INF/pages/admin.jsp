<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jimmim
  Date: 22.05.2020
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<form action="/add" method="post">
    login: <input type="text" name="login"/>
    Password: <input type="text" name="password"/>
    email: <input type="text" name="email"/>
    <br>
    <button type="submit">add</button>
</form>
<a href="<c:url value="/logout" />">Logout</a>
<br>
<table>
    <tr>
        <th> </th>
        <th>login</th>
        <th>password</th>
        <th>email</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td>
                <form action="/edit" method="get">
                    <input type="hidden" name="login" value="${user.login}">
                    <input type="hidden" name="password" value="${user.password}">
                    <input type="hidden" name="email" value="${user.email}">
                    <button type="submit" name="id" value="${user.id}">edit</button>
                </form>
            </td>
            <td>
                <form action="/delete" method="post">
                    <input type="hidden" name="login" value="${user.login}">
                    <input type="hidden" name="password" value="${user.password}">
                    <input type="hidden" name="email" value="${user.email}">
                    <button type="submit" name="id" value="${user.id}">delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
