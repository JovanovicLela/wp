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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        tfDate = new JTextField("Date and time:  " + sdf.format(new Date()));
        tfDate.setEditable(false);
        tfDate.setBackground(Color.DARK_GRAY.getHSBColor(0.5f, 0.2f, 1f));

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String formatDateTime = now.format(formatter);
                tfDate.setText("Date and time: " + formatDateTime);
            }
        }).start();

        add(tfDate);
    }
}
