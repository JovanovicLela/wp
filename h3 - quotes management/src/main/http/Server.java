package main.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int TCP_PORT = 8080;

    public static void main(String[] args) {

        /*
        String json = "{\"ime\": \"stefan\"}"; // zellimo ovo da serijalizujemo na neki objekat, na neku klasu npr User

        Gson gson = new Gson();
        User u = gson.fromJson(json, User.class);  //kao prvi argument string, kao drugi klasu gde serijalizujemo taj string
        u.prezime = "antic";
        System.out.println(gson.toJson(u));  // kao argument ide objekat koji zelimo da prebacimo u json

        System.out.println(u.ime);
        // ispis: stefan i ovde smo sa string json-a dobili objekat javine klase

        // Mozemo uraditi i obrnuto



         */

        try {
            ServerSocket serverSocket = new ServerSocket(TCP_PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
