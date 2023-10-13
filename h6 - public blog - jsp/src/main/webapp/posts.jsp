<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Posts</title>
    <%@ include file="styles.jsp"%>
</head>
<body>
<%@ include file="header.jsp" %>

    <div class="container">
        <h1 class="text-center">Objavljeni postovi</h1>
        <c:if test="${posts.size() == 0}">
            <h2>Nema objava.</h2>
        </c:if>
        <c:forEach var="post" items="${posts}">
            <div class="card">
                <div class="card-body">
                    <h5 class="d-inline-block card-title"><c:out value="${post.title}"/></h5>
                    <p class="d-inline-block float-right margin-top">
                        <small class="text-muted"><fmt:formatDate pattern="dd.MM.yyyy" value="${post.postdate}"/></small>
                    </p>
                    <c:if test="${post.content.length() > 200}">

                    </c:if>
                    <c:choose>
                        <c:when test="${post.content.length() > 200}">
                            <p class="card-text"><c:out value="${post.content.substring(0,200)}"/>...</p>
                        </c:when>
                        <c:otherwise>
                            <p class="card-text"><c:out value="${post.content}"/></p>
                        </c:otherwise>
                    </c:choose>
                    <p class="card-text"><small><a href="/posts/${post.id}">Opsirnije...</a></small></p>
                </div>
            </div>
        </c:forEach>

        <div class="mt-6">
            <form action="/new-post" method="get">
                <button style="margin-top: 25px" type="submit" class="btn btn-primary btn-lg">New Post</button>
            </form>
        </div>

    </div>

</body>
</html>
