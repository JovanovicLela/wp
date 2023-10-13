<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="styles.jsp"%>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <%--Kreiranje instance bean-a. Scope:
    application - instanca beana je dostupna celoj web aplikaciji
    session - instanca beana se kreira za svaku novu sesiju
    request - instanca beana se kreira kada stigne novi zahtev i dostupna je samo na nivou tog zahteva
    sto znaci da ce biti dostupan i drugim stranicama, na primer ako uradimo
     <jsp:forward page="stranica.jsp"/> ili <jsp:include page="stranica.jsp"/>
    page - instanca beana je dostupna samo jednoj jsp stranici --%>
    <jsp:useBean id="user" scope="session" class="rs.raf.demo.User" />

    <jsp:setProperty name="user" property="firstname" param="firstname" />
    <jsp:setProperty name="user" property="lastname" param="lastname" />

    <h1>Hello, <%= user.getFirstname() %>!</h1>

    <a href="index.jsp">Pocetna strana</a>

</div>

</body>
</html>
