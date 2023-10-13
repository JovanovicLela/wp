package raf.d2.controller;

import raf.d2.Notification;
import raf.d2.ServerView;
import raf.d2.threads.ServerMain;
import raf.d2.threads.ServerThread;

import java.awt.event.ActionListener;

public abstract class ControllerServer implements ActionListener, Notification {

    protected ServerView sv;

    public ControllerServer(ServerView sv) {
        this.sv = sv;
    }

}
