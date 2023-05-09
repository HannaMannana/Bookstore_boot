 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
     <html>
        <head>
            <title id="title">Book</title>
             <link rel="stylesheet" type="text/css" href="/css/utyle.css"/>
     <button id="button"><a id="linkB" href="getAll">Back</a></button>
        </head>

        <body>
            <h2 id="name">Book</h2>
            <h3 id="id"><p>Id: ${requestScope.book.id}</p>
            <p>ISBN: ${requestScope.book.isbn}</p>
            <p>Title: ${requestScope.book.bookName}</p>
            <p>Author: ${requestScope.book.author}</p>
            <p>Price: ${requestScope.book.price}</p>
            <p>Pages: ${requestScope.book.numberOfPages}</p>
            <p>Year of publication: ${requestScope.book.yearOfPublication}</p>
            <p>Cover: ${requestScope.book.coverType}</p></h3>



            <form action="update/${book.id}" method="get"><input id="buttonUp" type="submit" value="Update"></form>
            <form action="delete/${book.id}" method="post"><input id="buttonUp" type="submit" value="Delete"></form>


        </body>
    </html>
