package raf.d2.controller;

import raf.d2.Main;
import raf.d2.ServerView;
import raf.d2.threads.ServerMain;

import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.util.Iterator;

public class StartController extends ControllerServer{

    public StartController(ServerView sv) {
        super(sv);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            Thread threadStart = new Thread(new ServerMain());
            threadStart.start();

            sv.getTextArea().append("Server started...\n");
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
