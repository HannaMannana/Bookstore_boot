<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="/css/userAddForm.css"/>
 <title>Update User</title>
 </head>
<body>

  <form class="update-form" method="post" action="/users/update/${user.id}">
  <div class="container">
  <center>  <h1> User form</h1> </center>
  <hr>
  <label> Firstname </label>
<input type="text" name="name" placeholder= "Firstname" size="15" required value=${requestScope.user.name}>
<label> Lastname: </label>
<input type="text" name="lastName" placeholder="Lastname" size="15"required value=${requestScope.user.lastName}>

 <label for="email"><b>Email</b></label>
 <input type="text" placeholder="Enter Email" name="email" required value=${requestScope.user.email}>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <input name="id" placeholder="id" size="15" type="hidden" required value=${requestScope.user.id}>

    <label for="psw-repeat"><b>Re-type Password</b></label>
    <input type="password" placeholder="Retype Password" name="psw-repeat" required>
    <button type="submit" class="registerbtn">Update user</button>
</form>
</body>
</html>
