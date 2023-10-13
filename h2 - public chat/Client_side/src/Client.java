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
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Client extends JFrame {

    // JFrame related
    private static JTextArea textArea;
    private JButton btnStart, btnSend;
    private JPanel panelNorth, panelSouth, panelNorthSouth;
    private JLabel lblChatClient, lblName;
    private JTextField tfMessage, tfNickname;
    private StatusBar statusBar;
    public LocalDateTime now = null;

    // Socket related
    String username;
    String address = "localhost";
    int port = 2222;
    List<String> users = new ArrayList<>();
    boolean isConnected = false;

    Socket socket;
    BufferedReader in = null;
    PrintWriter out = null;

    public Client() {

        initialise();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                Object[] options;
                options = new Object[] {"Cancel", "Exit"};
                int answer = JOptionPane.showOptionDialog(Client.this, "Do you want to exit?", "Confirm exit",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (answer == JOptionPane.YES_OPTION || answer == JOptionPane.DEFAULT_OPTION) {
                    Client.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                if (answer == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public void initialise() {

        try {
            initialiseGUI();

            final String  DEFAULT_FONT_FAMILY = "Times New Roman";
            final int DEFAULT_FONT_SIZE = 20;
            UIManager.put("TextPane.font",
                    new Font(DEFAULT_FONT_FAMILY, Font.BOLD, DEFAULT_FONT_SIZE));
            SwingUtilities.updateComponentTreeUI(this);
            this.setVisible(true);
            this.setResizable(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initialiseGUI() {

        try {

            setTitle("Chat - Client");
            setSize(630, 520);
            setLocationRelativeTo(null);

            this.setIconImage(new ImageIcon(getClass().getResource("image/logo.png")).getImage());

            panelNorth = new JPanel();
            panelNorth.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(30, 10, 10, 10),
                    BorderFactory.createLoweredBevelBorder()));
            add(panelNorth, BorderLayout.NORTH);

            lblChatClient = new JLabel("CHAT CLIENT");
            lblChatClient.setHorizontalAlignment(SwingConstants.CENTER);
            lblChatClient.setFont(new Font("Times New Roman", Font.BOLD, 34));
            panelNorth.add(lblChatClient, BorderLayout.NORTH);

            panelNorthSouth = new JPanel();
            panelNorth.add(panelNorthSouth, BorderLayout.WEST);
            panelNorthSouth.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));

            lblName = new JLabel("User: ");
            lblName.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
            panelNorthSouth.add(lblName);
            tfNickname = new JTextField();
            tfNickname.setColumns(7);
            panelNorthSouth.add(tfNickname);

            btnStart = new JButton("CONNECT");
            btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            btnStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    connectAction(e);
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
            scroll.setVisible(true);
            scroll.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(10, 10, 10, 10),
                    BorderFactory.createLoweredBevelBorder()));
            add(scroll, BorderLayout.CENTER);

            panelSouth = new JPanel();
            add(panelSouth, BorderLayout.SOUTH);

            tfMessage = new JTextField();
            tfMessage.setColumns(40);
            tfMessage.setToolTipText("\tType your message here...");
            panelSouth.add(tfMessage);

            btnSend = new JButton("SEND");
            btnSend.setFont(new Font("Tahoma", Font.PLAIN, 12));
            btnSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sendAction(e);
                }
            });
            panelSouth.add(btnSend);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listenThread() {
        Thread thread = new Thread(new ClientThread());
        thread.start();
    }

    public class ClientThread implements Runnable {

        @Override
        public void run() {

            String[] data;
            String message, connect = "Connect", chat = "Chat";


            try {

                while ((message = in.readLine()) != null) {
                    data = message.split(":");

                    if (data[2].equals(chat)) {

                        textArea.append("[" + time() + "]   " + data[0] + ": " + data[1] + "\n");
                        textArea.setCaretPosition(textArea.getDocument().getLength());
                    } else if(data[2].equals(connect)) {
                        textArea.removeAll();
                        userAdd(data[0]);
                    }
                }
            } catch (Exception e) {
                textArea.setText("Server stopped.");
            }
        }
    }

    // ------------- UTILS ---------------

    private void connectAction(ActionEvent e) {

        if(isConnected == false) {
            username = tfNickname.getText();

            try {
                socket = new Socket(address, port);

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter((socket.getOutputStream()), true);
                out.println(username + ":has connected.:Connect");
                isConnected = true;
                textArea.append("Welcome!\n");

            } catch (Exception ex) {
                textArea.append("Cannot connect. Try again. \n");
            }

            listenThread();

        } else if (isConnected == true) {
            textArea.append("You are already connected. \n");
        }
    }

    private void sendAction(ActionEvent e) {
        String message = "";

        if ((tfMessage.getText()).equals(message)) {
            tfMessage.setText("");
            tfMessage.requestFocus();
        } else {

            try {
                out.println(username + ":" + tfMessage.getText() + ":Chat");
                out.flush();

            } catch (Exception ex) {
                textArea.append("Message was not sent.\n");
            }
            tfMessage.setText("");
            tfMessage.requestFocus();
        }
        tfMessage.setText("");
        tfMessage.requestFocus();
    }


    public void userAdd(String data) {
        users.add(data);
    }

    private String time() {
        now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }
}
