package rs.raf.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet(name = "proveriFormu", value = "/proveri-formu")
public class ProveriServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "C:\\Users\\lex59\\OneDrive\\Desktop\\Veb\\Vezbe 5\\demo\\demo\\src\\main\\resources\\" + "tim_" + request.getSession().getAttribute("imeTima") + ".txt";
        File f = new File(fileName);

        f.createNewFile();

        FileWriter fw = new FileWriter(f);
        fw.write("Ime tima: " + request.getSession().getAttribute("imeTima"));
        fw.write("\n\r");
        fw.write("Kontakt mejl: " + request.getSession().getAttribute("kontaktMejl"));
        fw.write("\n\r");
        fw.write("Kontakt telefon: " + request.getSession().getAttribute("kontaktTelefon"));
        fw.write("\n\r");
        fw.write("Moto tima: " + request.getSession().getAttribute("motoTima"));
        fw.write("\n\r");
        fw.write("Kako ste saznali za Hakaton: " + request.getSession().getAttribute("infoHakaton"));
        fw.write("\n\r");
        fw.write("Broj clanova: " + request.getSession().getAttribute("infoBroj"));
        fw.write("\n\r");
        fw.write("\n\r");


        for (int i = 0; i < (int)request.getSession().getAttribute("infoBroj"); i++) {
            String clan = request.getParameter("imeClana:"+(i+1)) + " " + request.getParameter("prezimeClana:"+(i+1));
            fw.write("Clan " + (i+1) + ": " + clan);
            fw.write("\n\r");
            fw.write("Mejl clana: " + request.getParameter("mejlClana:" + (i+1)));
            fw.write("\n\r");
            fw.write("Uloga: " + request.getParameter("ulogaClana:" + (i+1)));
            fw.write("\n\r");
            fw.write("LinkedIn: " + request.getParameter("linkedInClana:" + (i+1)));
            fw.write("\n\r");
            fw.write("\n\r");

        }

        fw.close();


        request.getSession().removeAttribute("kontaktMejl");
        request.getSession().removeAttribute("kontaktTelefon");
        request.getSession().removeAttribute("motoTima");
        request.getSession().removeAttribute("infoHakaton");
        request.getSession().removeAttribute("infoBroj");
        request.getSession().setAttribute("reg", "T");

        response.sendRedirect("poslataPrijava.jsp");
    }
}
