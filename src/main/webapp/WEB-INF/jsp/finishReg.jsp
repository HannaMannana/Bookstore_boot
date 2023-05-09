<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <title>BOOKSTORE</title>
    <link rel="stylesheet" type="text/css" href="/css/finishReg.css"/>


<body>
<nav class="nav-items">

      <a href="/">Home</a>
      <li><a href="/books/getAll">All books</a></li>
      <li><a href="/users/getAll">All users</a><li>
      <li><a href="/users/create">Sign up</a><li>
      <a href="#link">About</a>
    </nav>

<div class="title">
    <div class="title-text">

  <p id="text">Congratulate! <br>You are registered <br>
  <form method="post" action="http://localhost:8080/">
    <button id="button"><a id="linkB" href="/">Back</a></button>
    </div>
    <img id ="img" src="/image/Tiny people standing near big checkmark.jpg" style="width:100%"></p>
</div>

</body>
</html>