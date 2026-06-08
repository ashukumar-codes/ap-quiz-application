package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, back;

    AdminLogin() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        getClass().getResource("/icons/icon.png")));
        setContentPane(new GradientPanel());
        setBounds(400, 200, 500, 300);
        setLayout(null);


        JLabel heading = new JLabel("Admin Login");
        heading.setBounds(180, 20, 200, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 22));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel user = new JLabel("Username:");
        user.setBounds(80, 80, 100, 25);
        user.setForeground(Color.WHITE);
        add(user);

        username = new JTextField();
        username.setBounds(200, 80, 200, 25);
        add(username);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(80, 130, 100, 25);
        pass.setForeground(Color.WHITE);
        add(pass);

        password = new JPasswordField();
        password.setBounds(200, 130, 200, 25);
        add(password);

        login = new JButton("Login");
        login.setBounds(120, 190, 100, 30);
        styleButton(login);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(260, 190, 100, 30);
        styleButton(back);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    void styleButton(JButton b){
    b.setFocusPainted(false);
    b.setBorderPainted(false);
    b.setForeground(Color.WHITE);
    b.setBackground(new Color(30, 144, 255));
    b.setFont(new Font("Segoe UI", Font.BOLD, 14));
    b.setCursor(new Cursor(Cursor.HAND_CURSOR));

    // hover effect
    b.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            b.setBackground(new Color(0,120,215));
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            b.setBackground(new Color(30,144,255));
        }
    });
}

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            String user = username.getText();
            String pass = new String(password.getPassword());

            //ADMIN CREDENTIALS
            if (user.equals("Ashu") && pass.equals("9117")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                setVisible(false);
                new AdminPanel();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        }

        if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
}