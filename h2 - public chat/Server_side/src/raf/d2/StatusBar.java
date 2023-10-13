package raf.d2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StatusBar extends JPanel {

    public LocalDateTime now = null;
    private JTextField tfDate;

    public StatusBar() {

        String dt = "Date and time   ";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        tfDate = new JTextField(dt + sdf.format(new Date()));
        tfDate.setEditable(false);
        tfDate.setBackground(Color.getHSBColor(0.6f, 0.2f, 2f));

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formatDateTime = now.format(formatter);
                tfDate.setText("Date and time: " + formatDateTime);
            }
        }).start();

        add(tfDate);
    }
}
