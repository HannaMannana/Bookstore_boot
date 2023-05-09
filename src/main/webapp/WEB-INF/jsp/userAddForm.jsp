<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" type="text/css" href="/css/userAddForm.css"/>
 <title>Create user</title>
 </head>
<body>
<form method="post" action="/users/create">

  <div class="container">
  <center>  <h1> User registration form</h1> </center>
  <hr>
  <label> Firstname </label>
<input type="text" name="name" placeholder= "Firstname" size="15" required />
<label> Lastname: </label>
<input type="text" name="lastName" placeholder="Lastname" size="15"required />

 <label for="email"><b>Email</b></label>
 <input type="text" placeholder="Enter Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label for="psw-repeat"><b>Re-type Password</b></label>
    <input type="password" placeholder="Retype Password" name="psw-repeat" required>
    <button type="submit" class="registerbtn">Register</button>
</form>
</body>
</html>
