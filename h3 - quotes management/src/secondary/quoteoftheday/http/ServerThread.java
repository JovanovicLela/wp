package secondary.quoteoftheday.http;

import com.google.gson.Gson;
import main.http.HttpMethod;
import secondary.quoteoftheday.app.Quotes;
import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.StringTokenizer;

public class ServerThread implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private Random random;

    public ServerThread(Socket client) {
        this.client = client;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            gson = new Gson();
            random = new Random();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String requestLine = in.readLine();

            StringTokenizer stringTokenizer = new StringTokenizer(requestLine);

            String method = stringTokenizer.nextToken(); // METODA

            System.out.println("\nHTTP CLIENT REQUEST:\n");
            do {
                System.out.println(requestLine);
                requestLine = in.readLine();
            } while (!requestLine.trim().equals(""));

            if (method.equals(HttpMethod.GET.toString())) {
                StringBuilder quoteResponse = new StringBuilder();
                quoteResponse.append("HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n");
                quoteResponse.append(gson.toJson(Quotes.quotesOfTheDay[new Random().nextInt(Quotes.quotesOfTheDay.length)]));

                System.out.println("\nQUOTE OF THE DAY SERVER RESPONSE:\n");
                System.out.println(quoteResponse.toString());

                out.println(quoteResponse.toString());
            }

            in.close();
            out.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
