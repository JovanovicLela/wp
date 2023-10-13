package raf.d2.threads;

import raf.d2.ServerView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain implements  Runnable{

    ServerView sv;
    ServerThread serverThread;
    public static List clientOutputStreams;
    public static List<String> users;

    @Override
    public void run() {
        clientOutputStreams = new ArrayList();
        users = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(2222);

            while(true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(out);

                serverThread = new ServerThread(out, clientSocket);
                Thread thread = new Thread(serverThread);
                thread.start();
                sv.getTextArea().append("Got a connection. \n");
            }
        } catch (IOException e) {
            sv.getTextArea().append("Error making a connection. \n");
        }
    }

}
