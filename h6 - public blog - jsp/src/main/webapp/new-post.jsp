<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Post</title>
    <%@ include file="styles.jsp"%>
</head>
<body>
<%@ include file="header.jsp" %>

    <div class="container">
        <h1 class="text-center">Nova objava</h1>
        <form method="post" accept-charset="utf-8">
            <div class="form-group">
                <label for="author">Author</label>
                <input type="text" id="author" name="author" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="content">Content</label>
                <textarea class="form-control" id="content" name="content" rows="5" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-lg">Save Post</button>
        </form>

    </div>

</body>
</html>
