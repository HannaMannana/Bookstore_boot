 <%@ page language="java" contentType="text/html; charset=UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
     <html>
        <head>
             <link rel="stylesheet" type="text/css" href="/css/utyle.css"/>
            <title id="title">User</title>
           <button id="button"><a id="linkB" href="getAll">Back</a></button>
        </head>
        <body>
            <h2 id="name">User</h2>
            <h3 id="id"><p>Id: ${requestScope.user.id}</p>
            <p>Name: ${requestScope.user.name}</p>
            <p>Surname: ${requestScope.user.lastName}</p>
            <p>Email: ${requestScope.user.email}</p>
            <p>Password: ${requestScope.user.password}</p>
            <p>Role: ${requestScope.user.roleType}</p></h3>

             <form action="update/${user.id}" method="get"><input id="buttonUp" type="submit" value="Update"></form>
             <form action="delete/${user.id}" method="post"><input id="buttonUp" type="submit" value="Delete"></form>


        </body>
    </html>

