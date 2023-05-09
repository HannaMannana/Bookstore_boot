<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="/css/login.css">

    <title>Login</title>
<button id="button"><a id="linkB" href="/">Back</a></button>
</head>
<body>
<form class="login-form" action="/login" method="post">
<div class="container">
 <center>  <h1> Login</h1> </center>
  <hr>
 <label for="email"><b>Email</b></label>
 <input type="text" placeholder="Enter Email" name="email" required>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <button type="submit" class="registerbtn">Login</button>
</form>
</body>
</html>