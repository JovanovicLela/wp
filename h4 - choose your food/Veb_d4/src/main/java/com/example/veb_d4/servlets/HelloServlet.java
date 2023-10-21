package com.example.veb_d4.servlets;

import com.example.veb_d4.repository.Repository;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static com.example.veb_d4.constants.Constants.*;

@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {

    private Repository repository;

    public void init() {

        repository = Repository.getInstance();
        Map<String, String> map = new HashMap<>();
        getServletContext().setAttribute("map", map);

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html<head><title>Choose your food</title></head><body>");

        if (getServletContext().getAttribute(request.getSession().getId()) != null) {
            out.println("<h2>Successfully chosen!<h2>");
            return;
        }

        out.println("<h1>Choose your food</h1>");
        out.println("<form method=\"POST\" action=\"helloServlet\">");

        for (String day: days) {
            out.println("<h2>" + day + "</h2>");
            out.println("<label for=\"" + day + "\"></label>");
            out.println("<select id=\"" + day + "\" name=\"" + day + "\">");
            for(String meal: repository.getDataForDay(day).keySet())
                out.println("<option value=\"" + meal + "\">" + meal + "</option>");
            out.println("</select></br></br>");
        }

        out.println("<br/><button type=\"submit\">Submit order</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        out.println("<html><body><div>");
        out.println("<h2>" + "Order is created!" + "</h2>");
        out.println("</div></body></html>");

        Map<String, String> map = (Map<String, String>) getServletContext().getAttribute("map");


        for (String day : days) {
            Map<String, Integer> dayData = repository.getDataForDay(day);
            String parameterValue = req.getParameter(day);
            System.out.println(parameterValue);
            System.out.println("=====================");

            dayData.put(parameterValue, dayData.get(parameterValue) + 1);
            System.out.println(dayData.get(parameterValue) + 1);

            map.put(req.getSession().getId(), "active");
        }


    }

}