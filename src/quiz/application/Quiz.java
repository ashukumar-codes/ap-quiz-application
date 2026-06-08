package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class Quiz extends JFrame implements ActionListener {
    
    ArrayList<Question> qList = QuizData.questions;
    String useranswers[][] = new String[qList.size()][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
   
    String name;
    
    void styleButton(JButton b){
    b.setFocusPainted(false);
    b.setBorderPainted(false);
    b.setForeground(Color.WHITE);
    b.setBackground(new Color(30, 144, 255));
    b.setFont(new Font("Segoe UI", Font.PLAIN, 22));
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
    
    Quiz(String name) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        getClass().getResource("/icons/icon.png")));
        setContentPane(new GradientPanel());
        setLayout(null);
        
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setForeground(new Color(200,230,255));
        qno.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setForeground(Color.WHITE);
        question.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(question);
        
        
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        opt1.setIcon(null);
        opt2.setIcon(null);
        opt3.setIcon(null);
        opt4.setIcon(null);
        
        // style block
        Color glass = new Color(255,255,255,180);
        
        opt1.setBackground(glass);
        opt2.setBackground(glass);
        opt3.setBackground(glass);
        opt4.setBackground(glass);
        
        opt1.setForeground(Color.BLACK);
        opt2.setForeground(Color.BLACK);
        opt3.setForeground(Color.BLACK);
        opt4.setForeground(Color.BLACK);
        
        opt1.setBorderPainted(false);
        opt2.setBorderPainted(false);
        opt3.setBorderPainted(false);
        opt4.setBorderPainted(false);
        
        opt1.setFocusPainted(false);
        opt2.setFocusPainted(false);
        opt3.setFocusPainted(false);
        opt4.setFocusPainted(false);
        
        Font optFont = new Font("Segoe UI", Font.PLAIN, 18);
        opt1.setFont(optFont);
        opt2.setFont(optFont);
        opt3.setFont(optFont);
        opt4.setFont(optFont);
        
        JRadioButton[] opts = {opt1,opt2,opt3,opt4};
        
        for(JRadioButton o : opts){
            o.setBackground(glass);
            o.setForeground(new Color(30,30,30));
            o.setFont(optFont);
            o.setBorderPainted(false);
            o.setFocusPainted(false);
            o.setOpaque(true);o.setCursor(new Cursor(Cursor.HAND_CURSOR));
            o.setBorder(BorderFactory.createEmptyBorder(8,15,8,15));
            
            // hover glow
            o.addMouseListener(new java.awt.event.MouseAdapter(){
                public void mouseEntered(java.awt.event.MouseEvent e){
                    if(!o.isSelected())
                o.setBackground(new Color(255,255,255,230));
                }
                public void mouseExited(java.awt.event.MouseEvent e){
                    if(!o.isSelected())
                         o.setBackground(glass);
                }
            });
            
            // selection highlight
            o.addActionListener(e -> {
                for(JRadioButton x:opts)
                    x.setBackground(glass);
                
                o.setBackground(new Color(200,230,255));
            });
        }
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.addActionListener(this);
        styleButton(next);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.addActionListener(this);
        styleButton(lifeline);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.addActionListener(this);
        submit.setEnabled(false);
        styleButton(submit);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
           useranswers[count][0] = ""; 
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(qList.get(i).correct)) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + "seconds"; //15
        // glow shadow
        g.setColor(new Color(255, 120, 120, 120));
        g.setFont(new Font("Segoe UI", Font.BOLD, 26));
        
        
        // main timer text
        g.setColor(new Color(255,80,80));
        g.setFont(new Font("Segoe UI", Font.BOLD, 22));
        
        if (timer > 0) {
            g.drawString(time, 1100, 500);
            } else {
            g.drawString("Time up!!", 1100, 500);
        }
        
    timer--; //14
    
    try {
        Thread.sleep(1000);
        repaint();
    }catch (Exception e) {
        e.printStackTrace();
    }
    
    if (ans_given == 1) {
        ans_given = 0;
        timer = 15;
    } else if (timer < 0) {
        timer = 15;
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        
        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        if (count == 9) { // submit button
           if (groupoptions.getSelection() == null) {
           useranswers[count][0] = ""; 
           } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
           }
           
           for (int i = 0; i < useranswers.length; i++) {
               if (useranswers[i][0].equals(qList.get(i).correct)) {
                   score += 10;
               } else {
                   score += 0;
               }
           }
           setVisible(false);
           new Score(name, score);
        } else { // next button
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            count++; // 0 // 1
            start(count);
        }
    }
    
}
    
    public void start(int count) {
        if (qList.size() == 0) {
            JOptionPane.showMessageDialog(this, "No questions available! Please ask admin to add questions.");
            return;
        }
        if (count >= qList.size()) {
        return;
        }
        Question q = qList.get(count);
        qno.setText("" + (count + 1) + ". ");
        question.setText(q.question);
        opt1.setText(q.opt1);
        opt2.setText(q.opt2);
        opt3.setText(q.opt3);
        opt4.setText(q.opt4);
        
        opt1.setActionCommand(q.opt1);
        opt2.setActionCommand(q.opt2);
        opt3.setActionCommand(q.opt3);
        opt4.setActionCommand(q.opt4);
        
        groupoptions.clearSelection();
    }
   
    public static void main(String[] args) {
    new Quiz("User");
    }
}


