package quiz.application;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash() {
        setSize(600,400);
        setLocationRelativeTo(null);
        setUndecorated(true);

        setContentPane(new GradientPanel());
        setLayout(new BorderLayout());

        JLabel title = new JLabel("AP QUIZ APPLICATION", JLabel.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.CENTER);

        setVisible(true);

        javax.swing.Timer t = new javax.swing.Timer(2000, e -> {
            new Login();
            dispose();
        });
        t.setRepeats(false);
        t.start();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
