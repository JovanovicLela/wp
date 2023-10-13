package raf.d2.controller;

import raf.d2.ServerView;
import raf.d2.threads.ServerMain;

import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.util.Iterator;

public class EndController extends  ControllerServer{

    public EndController(ServerView sv) {
        super(sv);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        notifyEveryone("Server is stopping and all users will be disconnected. \n:Chat");
        sv.getTextArea().setText("Server is stopping... \n");
        sv.getTextArea().setText("");
    }

    @Override
    public void notifyEveryone(String message) {
        Iterator it = ServerMain.clientOutputStreams.iterator();

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
