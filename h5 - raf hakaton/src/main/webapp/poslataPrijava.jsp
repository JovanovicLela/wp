<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hakaton</title>
    <%@include file="styles.jsp"%>
</head>
<body data-aos-easing="ease" data-aos-duration="400" data-aos-delay="0">
<%@include file="header.jsp"%>

<div class="container">
    <div style="width: 1000px" class="row h-50 justify-content-center align-items-center">
        <h2 style="margin-top: 200px" class="flexBox"><%= request.getSession().getAttribute("imeTima") %>, hvala na prijavi!</h2>
        <h2 class="text-center">Naš tim pregleda prijavu i obavestiće vas o konačnoj odluci do 11. decembra na mejl: stefanantic7@gmail.com</h2>
        <h2 class="flexBox">Za sva dodatna pitanja možete pisati na: hakaton@raf.rs</h2>
    </div>
</div>

</body>
</html>
