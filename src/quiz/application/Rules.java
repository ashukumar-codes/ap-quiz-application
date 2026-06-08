package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{
    
    String name;
    JButton start, back;
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
    
    Rules(String name) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        getClass().getResource("/icons/icon.png")));
        setContentPane(new GradientPanel());
        setLayout(null);
        
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to AP Quiz");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setForeground(Color.LIGHT_GRAY);
        rules.setFont(new Font("Tahoma", Font.BOLD, 16));
        rules.setText(
                "<html>" +
                "1. Read the question carefully before answering it" + "<br><br><br>" +
                "2. This is a multiple-choice question. Each question will have four options. You must choose one of these options" + "<br><br><br>" +
                "3. You have to answer each question within 15 seconds" + "<br><br><br>" +
                "4. After answering each question, click on the Next button" + "<br><br><br>" +
                "5. If you wish, you can use the 50-50 lifeline on any question. Once used, the 50-50 lifeline button will be disabled. " + "<br><br><br>" +
            "<html>"
        );
        add(rules);
        
        back = new JButton("back");
        back.setBounds(250, 500, 100, 30);
        back.addActionListener(this);
        styleButton(back);
        add(back);
        
        start = new JButton("start");
        start.setBounds(400, 500, 100, 30);
        start.addActionListener(this);
        styleButton(start);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        }else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}