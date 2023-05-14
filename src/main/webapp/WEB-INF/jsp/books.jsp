<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="/css/test.css">
        <title id="title">Books</title>
    </head>
    <body>

     <button id="button"><a id="linkB" href="/">Back</a></button>
     <button id="buttonAddBook"><a id="linkB" href="create">Add new book</a></button>
        <h1 id="name">Our Books</h1>

       <div class="pagination">
           <c:if test="${current >1}">
       <a href="/books/getAll/?page=${current - 1}&size=${size}">&laquo;</a>
           </c:if>
           <c:forEach begin="1" end="${total}" varStatus="i">
           <c:choose>
           <c:when test="${i.index ==current}">
              <a href="?page=${i.current}&size=${size}">${i.index}</a>
           </c:when>
            <c:otherwise>
               <a href="?page=${i.current}&size=${size}">${i.index}</a>
            </c:otherwise>
            </c:choose>
            </c:forEach>
              <c:if test="${current < total}">
       <a href="/books/getAll?page=${current + 1}&size=${size}">&raquo;</a>
              </c:if>
       </div>
            <table>
                <br>
                  <tr>
                <h3><td>Number</td><h3>
                <h3><td>Id</td><h3>
                <h3><td>Title</td><h3>
                <h3><td>Author</td><h3>
                   </tr>
                <c:forEach items="${books}" var="book" varStatus="counter">
                    <tr>
                    <td id="count">${counter.count}</td>
                     <td id="id"><a id="link" href="${book.id}"><c:out value="${book.id}"/></a></td>
                    <td id="bookName">${book.bookName}</td>
                    <td id="author">${book.author}</td>
                    </tr>
            </c:forEach>
          </table>
      </body>
</html>



