<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Single Post</title>
    <%@ include file="styles.jsp"%>
</head>
<body>

<%@ include file="header.jsp" %>

    <div class="container">
        <h8><fmt:formatDate pattern="dd.MM.yyyy" value="${post.postdate}"/></h8>
        <br>
        <h2 class="text-center"><c:out value="${post.title}"/></h2>
        <br>

        <figure class="text-center">
            <blockquote class="blockquote"> <c:out value="${post.content}"/> </blockquote>
            <figcaption style="font-size: 18px" class="blockquote-footer"> <c:out value="${post.author}"/> </figcaption>
        </figure>

        <div class="row"> <div class="col"><h4>Comments:</h4>
        <c:forEach var="comment" items="${post.comments}">
            <div class="card">
                <div class="card-body" ></div>
                <h5 style="margin-left: 5px; margin-right: 5px" class="card-title"><b><c:out value="${comment.name}"/></b>- <c:out value="${comment.comment}"/></h5>
                <br>
            </div>
        </c:forEach>
        </div>
        </div>

        <br>
        <br>
        <h4>New comment</h4>
        <br>

        <form method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="comment">Comment</label>
                <textarea type="text" rows="5" cols="50" class="form-control" id="comment" name="comment" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-lg">Comment</button>
        </form>
        <br>
    </div>

</body>
</html>
