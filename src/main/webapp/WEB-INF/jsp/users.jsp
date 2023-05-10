<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="/css/test.css">
        <title id="title">Users</title>
    </head>
    <body>
    <button id="button"><a id="linkB" href="/">Back</a></button>
        <h1 id="name">Our Users</h1>
 <a href="/users/getAll?page=${current - 1}&size=${size}">Prev</a>
         <p>Page: ${current + 1} of ${total}</p>
         <a href="/users/getAll?page=${current + 1}&size=${size}">Next</a>
            <table>
                <br>
                    <tr>
                <h3><td>Number</td><h3>
                <h3><td>id</td><h3>
                <h3><td>Email</td><h3>
                <h3><td>Password</td><h3>
                   </tr>
              <c:forEach items="${users}" var="user" varStatus="counter">
                <tr>
                    <td id="counter">${counter.count}</td>
                    <td id="id"><a id="link" href="${user.id}"><c:out value="${user.id}"/></a></td>
                    <td id="email">${user.email}</td>
                    <td id="pass">${user.password}</td>
                    </tr>
            </c:forEach>
           </table>
    </body>
</html>

