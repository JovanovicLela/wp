package raf.d2.threads;

import raf.d2.ServerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

public class ServerThread implements Runnable{

    ServerView sv;
    BufferedReader in = null;
    PrintWriter out; // client
    Socket socket; // client socket

    static List clientOutputStreams = ServerMain.clientOutputStreams;
    static List<String> users = ServerMain.users;

    public ServerThread(PrintWriter user, Socket clientSocket) {

        out = user;

        socket = clientSocket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
           sv.getTextArea().append("Unexpected error...\n");
        }
    }

    @Override
    public void run() {

        String message, connect = "Connect", chat = "Chat";
        String[] data;

        try {

            while ((message = in.readLine()) != null) {

                sv.getTextArea().append("Received: " + message + "\n");
                data = message.split(":");

                if (data[2].equals(connect)) {
                    notifyEveryone((data[0] + ":" + data[1] + ":" + chat));
                    userAdd(data[0]);
                } else if (data[2].equals(chat)) notifyEveryone(message);

            }

        } catch (Exception e) {
            sv.getTextArea().append("Lost a connection. \n");
            ServerMain.clientOutputStreams.remove(out);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                out.close();
            }

            if(this.socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void userAdd(String data) {

        String message, add = ": :Connect", name = data;
        users.add(name);
        String[] users = new String[(this.users.size())];
        this.users.toArray(users);

        for (String s : users) {
            message = (s + add);
            notifyEveryone(message);
        }
    }

    public void notifyEveryone(String message) {

        Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) {

            try {

                PrintWriter out = (PrintWriter) it.next();
                out.println(message);
                out.flush();
                sv.getTextArea().setCaretPosition(sv.getTextArea().getDocument().getLength());

            } catch (Exception e) {
                sv.getTextArea().append("Error telling everyone...\n");
            }
        }
    }

}
