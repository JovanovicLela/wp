package rs.raf.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProveriTim", value = "/proveri-tim")
public class ProveriTimServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ime = request.getParameter("imeTima");
        String mejl = request.getParameter("kontaktMejl");
        String tel = request.getParameter("kontaktTelefon");
        String moto = request.getParameter("motoTima");
        String hakInfo = request.getParameter("infoHakaton");
        int brInfo = Integer.parseInt(request.getParameter("infoBroj"));

        request.getSession().setAttribute("imeTima", ime);
        request.getSession().setAttribute("kontaktMejl", mejl);
        request.getSession().setAttribute("kontaktTelefon", tel);
        request.getSession().setAttribute("motoTima", moto);
        request.getSession().setAttribute("infoHakaton", hakInfo);
        request.getSession().setAttribute("infoBroj", brInfo);

        response.sendRedirect("formaClanovi.jsp");
    }
}
