<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

   <head>
    <link rel="stylesheet" href="/css/indexstyle.css">
    <title>Main Page</title>
   </head>
<body>
<nav class="nav-items">
      <a href="/">Home</a>
     <a href="/books/getAll">All books</a>
      <a href="/users/getAll">All users</a>
      <c:if test="${sessionScope.user != null}">
            <a href="/logout">Logout</a>
          </c:if>
          <c:if test="${sessionScope.user == null}">
             <a href="/users/create">Sign up</a>
            <a href="/login">Login</a>
          </c:if>
      <a href="#link">About</a>
    </nav>

<div class="title">
    <div class="title-text">
     <h2>Read for <br>the soul</h2>
  <p id="text">The books that help you the most <br>are those which make you think <br>the most.<br>
  <button id="button" href="">Read more</button>
  </div>
    <img id ="img" src="/image/6768291.jpg" style="width:30%"></p>
</div>
</body>
</html>
