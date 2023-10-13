<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Prijava timova</title>
    <%@include file="styles.jsp"%>
</head>
<body>

<%@include file="header.jsp"%>

    <div class="container h-80">
        <div class="row h-100 justify-content-center align-items-center">
            <form action="proveri-tim" method="post">
                <div style="width: 800px" class="form-group mb-4 col-6 mx-auto">
                    <h2 id="h_prijava">PRIJAVA TIMA</h2>
                    <br>
                    <input type="text" id="imeTima" class="input-group" name="imeTima" placeholder="Ime tima" required>
                </div>
                <div class="form-group mb-4 col-6 mx-auto">
                    <input type="email" id="kontaktMejl" class="input-group" name="kontaktMejl" placeholder="Kontakt mejl" required>
                </div>
                <div class="form-group mb-4 col-6 mx-auto">
                    <input type="telefon" id="kontaktTelefon" class="input-group" name="kontaktTelefon" placeholder="Kontakt telefon" required>
                </div>
                <div class="form-group mb-4 col-6 mx-auto">
                    <input type="motoTima" id="motoTima" class="input-group" name="motoTima" placeholder="Moto tima" required>
                </div>
                <div class="form-group mb-4 col-6 mx-auto">
                    <select id="info_hakaton" name="infoHakaton" class="form-select-lg" required>
                        <option selected>Kako ste čuli za Hakaton?</option>
                        <option name="Facebook">Facebook</option>
                        <option name="Instagram">Instagram</option>
                        <option name="LinkedIn">LinkedIn</option>
                        <option name="Fakultet">Fakultet</option>
                        <option name="Drugo">Drugo</option>
                    </select>
                </div>
                <div class="form-group mb-3 col-6 mx-auto">
                    <select id="info_broj" name="infoBroj" class="form-select-lg">
                        <option selected>Broj članova</option>
                        <option name="3">3</option>
                        <option name="4">4</option>
                    </select>
                </div>
                <div class="form-group mb-3 col-6 mx-auto">
                    <button class="btn btn-primary btn-lg center" type="submit">ČLANOVI</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>
