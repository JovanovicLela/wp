package raf.d2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ServerView extends JFrame {

    private static JTextArea textArea;
    private JButton btnStart, btnEnd;
    private JPanel panelNorth, panelSouth, panelNorthSouth;
    private JLabel lblChatClient, lblName;
    private StatusBar statusBar;

    private List clientOutputStreams;
    private List<String> users;
    private List<String> history;
    private boolean isEnd = true;
    Socket socket = null;

    private int counter;
    public LocalDateTime now = null;



    public ServerView() {

        initialise();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                Object[] options;
                options = new Object[]{"Cancel", "Stop"};
                int answer = JOptionPane.showOptionDialog(ServerView.this, "Do you want to stop the server?", "Confirm exit",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (answer == JOptionPane.YES_NO_OPTION || answer == JOptionPane.DEFAULT_OPTION) {
                    ServerView.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }

                if (answer == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void initialise() {

        initialiseGUI();

        final String DEFAULT_FONT_FAMILY = "Times New Roman";
        final int DEFAULT_FONT_SIZE = 20;
        UIManager.put("TextPane.font", new Font(DEFAULT_FONT_FAMILY, Font.BOLD, DEFAULT_FONT_SIZE));
        SwingUtilities.updateComponentTreeUI(this);
        this.setVisible(true);
        this.setResizable(false);

    }

    private void initialiseGUI() {

        setTitle("Chat - Server");
        setSize(630, 520);
        setLocationRelativeTo(null);

        this.setIconImage(new ImageIcon(getClass().getResource("image/logo.png")).getImage());

        panelNorth = new JPanel();
        panelNorth.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(30, 10, 10, 10),
                BorderFactory.createLoweredBevelBorder()));
        add(panelNorth, BorderLayout.NORTH);

        lblChatClient = new JLabel("CHAT SERVER");
        lblChatClient.setHorizontalAlignment(SwingConstants.CENTER);
        lblChatClient.setFont(new Font("Times New Roman", Font.BOLD, 34));
        panelNorth.add(lblChatClient, BorderLayout.NORTH);

        panelNorthSouth = new JPanel();
        panelNorth.add(panelNorthSouth, BorderLayout.AFTER_LAST_LINE);
        panelNorthSouth.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));

        lblName = new JLabel("Server: ");
        lblName.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        panelNorthSouth.add(lblName);

        btnStart = new JButton("START");
        btnStart.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
       // btnStart.addActionListener(new StartController(this));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAction(e);
            }
        });
        panelNorthSouth.add(btnStart);

        statusBar = new StatusBar();
        panelNorthSouth.add(statusBar);

        textArea = new JTextArea();
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setBorder(new EmptyBorder(5, 15, 15, 15));

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setMinimumSize(new Dimension(200, 150));
        scroll.setVerticalScrollBarPolicy(22);
        add(scroll, BorderLayout.CENTER);

        panelSouth = new JPanel();
        add(panelSouth, BorderLayout.SOUTH);

        btnEnd = new JButton("END");
        btnEnd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        //btnEnd.addActionListener(new EndController(this));
        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    endAction(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panelSouth.add(btnEnd);
    }

    public class ServerThread implements Runnable {

        BufferedReader in = null;
        PrintWriter out; // client
       // Socket socket; // client socket

        public ServerThread(PrintWriter user, Socket clientSocket) {

            out = user;

            try {
                socket = clientSocket;
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                textArea.append("Unexpected error...\n");
            }
        }


        @Override
        public void run() {

            String message, connect = "Connect", chat = "Chat";
            String censoredWord = "proba";
            StringBuilder censoredPrint = new StringBuilder(censoredWord);
            String[] data;

            try {

                while ((message = in.readLine()) != null) {

                        textArea.append("Received: [" + time() + "]  " + message + "\n");
                        data = message.split(":");

                        if (data[2].equals(connect)) {

                            ServerView.this.notify((data[0] + ":" + data[1] + ":" + chat));
                            counter++;
                           // history.add((data[0] + ":" + data[1] + ":" + chat + "\n"));
                            userAdd(data[0]);
                        } else if (data[2].equals(chat)) {

                            if (data[1].equals(censoredWord) || data[1].contains(censoredWord)) {

                                for (int i = 1; i < censoredPrint.length() - 1; i++) {
                                    censoredPrint.setCharAt(i, '*');
                                }
                                message = data[0] + ":" + censoredPrint + ":" + chat;
                            }
                            ServerView.this.notify(message);
                            history.add(message);
                            counter++;

                        }

                        if(counter <= 100)  // 100
                            continue;
                        else if(counter > 100) {
                            textArea.append("The limit has been exceeded.\n");
                            //  message = "Server je stao";
                            //  ServerView.this.notify(message);
                            socket.close();
                        }


                }

            } catch (Exception e) {
                textArea.append("Lost a connection. \n");
                clientOutputStreams.remove(out);
            }
        }
    }



    public class ServerMain implements Runnable {

        @Override
        public void run() {
            clientOutputStreams = new ArrayList();
            users = new ArrayList<>();
            history = new ArrayList<>();

            try {
                ServerSocket serverSocket = new ServerSocket(2222);

                while(true) {
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                    clientOutputStreams.add(out);

                    Thread thread = new Thread(new ServerThread(out, clientSocket));
                    thread.start();
                    textArea.append("Got a connection. \n");
                }
            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                textArea.append("Error making a connection. \n");

            }
        }
    }



    private void startAction(ActionEvent e) {
        Thread threadStart = new Thread(new ServerMain());
        threadStart.start();
        textArea.append("Server started...\n");
    }



    private void endAction(ActionEvent e) throws IOException {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

       // ServerView.this.notify( \n:Chat");
        textArea.setText("Server stopped. \n");
        //textArea.setText(null);
        socket.close();
    }


    private void userAdd(String data) {

        String message, add = ": :Connect", name = data;
        users.add(name);
        String[] users = new String[(this.users.size())];
        this.users.toArray(users);

        for (String s : users) {
            message = (s + add);
           // notify(Arrays.toString(history.toArray()));
            notify(message);
        }
    }

    private void notify(String message) {

        Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) {

            try {

                PrintWriter out = (PrintWriter) it.next(); // ovo je za klijente
                out.println(message);
                out.flush();
                textArea.setCaretPosition(textArea.getDocument().getLength());

            } catch (Exception e) {
                textArea.append("Error telling everyone.\n");

            }
        }
    }

    private String time() {
        now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }


    public static JTextArea getTextArea() {
        return textArea;
    }

    public List getClientOutputStreams() {
        return clientOutputStreams;
    }

    public void setClientOutputStreams(List clientOutputStreams) {
        this.clientOutputStreams = clientOutputStreams;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
