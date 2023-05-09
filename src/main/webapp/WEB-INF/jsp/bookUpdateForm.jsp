<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="/css/userAddForm.css"/>
 <title>Update book</title>
 </head>
<body>
<form class="update-form" method="post" action="/books/update/${book.id}">

  <div class="container">
  <center>  <h1> Book update form</h1> </center>
  <hr>
  <label> Isbn: </label>
<input type="text" name="isbn" placeholder= "Isbn"  required value="${book.isbn}">

<label> Title: </label>
<input type="text" name="bookName" placeholder="Title"  required value="${book.bookName}">

 <label>Author: </label>
 <input type="text" placeholder="Author" name="author" required value= "${book.author}">

<label>Price: </label>
 <input type="text" placeholder="Price" name="price" required value="${book.price}">

<label>Number of pages: </label>
 <input type="text" placeholder="Number of pages" name="numberOfPages" required value="${book.numberOfPages}">

 <label>Year of publication: </label>
  <input type="text" placeholder="Year of publication" name="yearOfPublication" required value="${book.yearOfPublication}">

  <input name="id" placeholder="id" size="15" type="hidden" required value=${requestScope.book.id}>

  <fieldset>
      <legend>Type of cover:</legend>

      <div>
        <input type="radio" id="SOFT" name="type" value="SOFT" ${requestScope.book.coverType=="SOFT" ? 'checked':''}>
        <label for="SOFT">SOFT</label>
      </div>

      <div>
        <input type="radio" id="HARD" name="type" value="HARD" ${requestScope.book.coverType=="HARD" ? 'checked':''}>
        <label for="HARD">HARD</label>
      </div>

      <div>
        <input type="radio" id="SPECIAL" name="type" value="SPECIAL" ${requestScope.book.coverType=="SPECIAL" ? 'checked':''}>
        <label for="SPECIAL">SPECIAL</label>
      </div>
  </fieldset>

  <button type="submit" class="registerbtn">Update book</button>
</form>
</body>
</html>

