package com.example.veb_d4.servlets;

import com.example.veb_d4.repository.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

import static com.example.veb_d4.constants.Constants.*;

@WebServlet(name = "ordersServlet", value = "/orders")
public class OrdersServlet extends HttpServlet {

    private String password = null;
    private Repository repository;

    public void init() {

        repository = Repository.getInstance();
        loadPassword();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if (req.getParameter("password") == null || !req.getParameter("password").equals(password)) {
            out.println("<html><body><div>");
            out.println("<h2>" + "Incorrect password! Try again." + "</h2>");
            out.println("</div></body></html>");
            return;
        }

        out.println("<html><body><form method=\"POST\" action=\"orders?password="+password+"\">");
        out.println("<br><input type=\"submit\" name=\"submit\" value=\"Delete\"/></form></body></html>");

        for (String day: days) {
            out.println("<h2>" + day + "</h2>");
            for (String meal: repository.getDataForDay(day).keySet()) {
                System.out.println(meal);
                out.println("<h4>" + meal  + " : " + repository.getDataForDay(day).get(meal)+ "</h4>");
                System.out.println(repository.getDataForDay(day).get(meal));
            }
            out.println("</br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        out.println("<html><body><div>");
        out.println("<h2>" + "Orders deleted!" + "</h2>");
        out.println("</div></body></html>");
        reset();
        //res.sendRedirect("/orders?password="+password);
    }

    private void loadPassword() {
        try {
            FileReader fr = new FileReader(PATH + PASSWORD_FILE);
            BufferedReader br = new BufferedReader(fr);
            if (br.ready())
                password = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        for (String day: days) {
            for (String meal: repository.getDataForDay(day).keySet()) {
                repository.getDataForDay(day).put(meal, 0);
            }
        }
        Map<String, String> map = (Map<String, String>) getServletContext().getAttribute("map");
        for (String id: map.keySet()) {
            getServletContext().removeAttribute(id);
        }
        map.clear();
    }
}
