package main.http;

import main.app.RequestHandler;
import main.http.response.Response;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ServerThread implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ServerThread(Socket client) throws IOException {
        this.client = client;

        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);

    }

    @Override
    public void run() {

        try {
            String requestLine = in.readLine();

            StringTokenizer stringTokenizer = new StringTokenizer(requestLine);

            String method = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();

            HashMap<String, String> postElementsForm = new HashMap<>();

            System.out.println("\nHTTP ZAHTEV KLIJENTA:\n");
            do {
                System.out.println(requestLine);
                requestLine = in.readLine();

            } while (!requestLine.trim().equals(""));

            if(method.equals(HttpMethod.POST.toString())) {
                // TODO: Ako je request method POST, procitaj telo zahteva (parametre)

                char[] buffer  = new char[2048];
                in.read(buffer);
                String parameters = new String(buffer);
                System.out.println(parameters);
                String[] parametersArray = parameters.split("&");
                for (String pairs: parametersArray) {
                    postElementsForm.put(pairs.split("=")[0], URLDecoder.decode(pairs.split("=")[1], StandardCharsets.UTF_8.name()));
                }
            }

            Request request = new Request(HttpMethod.valueOf(method), path, postElementsForm);

            RequestHandler requestHandler = new RequestHandler();
            Response response = requestHandler.handle(request);

            System.out.println("\nHTTP odgovor:\n");
            System.out.println(response.getResponseString());

            out.println(response.getResponseString());

            in.close();
            out.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
