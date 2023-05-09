<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" type="text/css" href="/css/userAddForm.css"/>
 <title>Create book</title>
 </head>
<body>
<form method="post" action="/books/create">

  <div class="container">
  <center>  <h1> Book form</h1> </center>
  <hr>
  <label> Isbn: </label>
<input type="text" name="isbn" placeholder= "Isbn" size="15" required />

<label> Title: </label>
<input type="text" name="bookName" placeholder="Title" size="100"required />

 <label>Author</label>
 <input type="text" placeholder="Author" name="author" required>

<label>Price</label>
 <input type="text" placeholder="Price" name="price" required>

<label>NumberOfPages</label>
 <input type="text" placeholder="Number of pages" name="numberOfPages" required>

 <label>YearOfPublication</label>
  <input type="text" placeholder="Year of publication" name="yearOfPublication" required>


    <button type="submit" class="registerbtn">Add book</button>
</form>
</body>
</html>


