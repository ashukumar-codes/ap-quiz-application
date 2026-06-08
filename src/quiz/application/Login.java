package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.BorderFactory;

public class Login extends JFrame implements ActionListener {
    
    JButton user, back;
    JTextField tfname;
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
    
    Login() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        getClass().getResource("/icons/icon.png")));
        setContentPane(new GradientPanel());
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        QuizData.loadFromFile();
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);
        
        JLabel heading = new JLabel("AP Quiz ");
        heading.setBounds(770, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        JLabel name = new JLabel("Enter your name");
        name.setBounds(809, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        name.setForeground(Color.GREEN);
        add(name);
        
        tfname= new JTextField();
        tfname.setBounds(735, 200, 300, 35);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tfname.setBackground(new Color(255,255,255,200));
        tfname.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        add(tfname);
        
        user = new JButton("User Login");
        user.setBounds(835, 300, 120, 35);
        user.addActionListener(this);
        styleButton(user);
        add(user);
        
        back = new JButton("back");
        back.setBounds(985, 300, 120, 35);
        back.addActionListener(this);
        styleButton(back);
        add(back);
        
        JButton admin = new JButton("Admin Login");
        admin.setBounds(685, 300, 120, 35);
        styleButton(admin);
        add(admin);
        
        admin.addActionListener(e -> {
            setVisible(false);
            new AdminLogin();
            });
        
        
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == user) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);    
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();  
    }
}

