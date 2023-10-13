<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Prijava clanova</title>
    <%@include file="styles.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<%! int broj = 3; %>

<div class="container">
    <div class="row">

        <% if (request.getSession().getAttribute("reg") != null && request.getSession().getAttribute("reg").equals("T")) { %>
        <h4 style="margin-top: 120px" class="col-6 mx-auto">Već ste se prijavili.</h4>
        <% }else {
        %>

        <form action="/proveri-formu" method="post">

            <%
                broj = (int)request.getSession().getAttribute("infoBroj");
                for (int i = 0; i < broj; i++) {
            %>

            <h1 style="margin-top: 100px; align-items: center" class="mb-3 col-6 mx-auto">Haker <%= i+1 %></h1>
            <div style="width: 700px" class="form-group mb-3 col-6 mx-auto">
                <input style="color: black" class="form-control" required type="text" placeholder="Ime" id="imeClana:<%= i+1 %>" name="imeClana:<%= i+1 %>">
            </div>
            <div class="form-group mb-3 col-6 mx-auto">
                <input style="color: black" class="form-control" required type="text" placeholder="Prezime" name="prezimeClana:<%= i+1 %>">
            </div>
            <div class="form-group mb-3 col-6 mx-auto">
                <input style="color: black" class="form-control" required type="email" placeholder="Mejl" name="mejlClana:<%= i+1 %>">
            </div>
            <div class="form-group mb-3 col-6 mx-auto">
                <input style="color: black" class="form-control" required type="text" placeholder="Uloga u timu" name="ulogaClana:<%= i+1 %>">
            </div>
            <div class="form-group mb-3 col-6 mx-auto">
                <input style="color: black" class="form-control" required type="url" placeholder="LinkedIn"  name="linkedInClana:<%= i+1 %>">
            </div>
            <% } %>

            <div class="form-group mb-3 col-6 mx-auto">
                <input type="submit" class="btn btn-primary btn-lg" value="Posalji prijavu">
            </div>
        </form>
        <% } %>
    </div>
</div>


</body>
</html>
