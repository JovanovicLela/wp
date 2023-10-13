package main.app;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class QuoteOfTheDay {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;

    private QuoteOfTheDay() {
        gson = new Gson();
    }

    private static class QuoteOfTheDayHolder {
        private static QuoteOfTheDay instance = new QuoteOfTheDay();
    }

    public static QuoteOfTheDay getInstance() {
        return QuoteOfTheDayHolder.instance;
    }

    public Quote getQuoteOfTheDay() {
        try {
            socket = new Socket("localhost", 8081);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            StringBuilder quoteRequest = new StringBuilder();
            quoteRequest.append("GET / HTTP/1.1\r\nHost: localhost:8081\r\n\r\n");
            out.println(quoteRequest.toString());
            String reqLine = in.readLine();

            do {
                System.out.println(reqLine);
                reqLine = in.readLine();
            } while (!reqLine.trim().equals(""));

            String quoteJson = in.readLine();
            System.out.println(quoteJson);

            Quote responseQuote = gson.fromJson(quoteJson, Quote.class);

            in.close();
            out.close();
            socket.close();

            return responseQuote;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
