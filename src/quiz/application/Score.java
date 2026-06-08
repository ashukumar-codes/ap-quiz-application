package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
    private void styleButton(JButton b) {
    b.setFocusPainted(false);
    b.setBorderPainted(false);
    b.setForeground(Color.WHITE);
    b.setBackground(new Color(60, 140, 255));
    b.setFont(new Font("Segoe UI", Font.BOLD, 16));
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
    
    Score(String name, int score) {
        Leaderboard.saveScore(name, score);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        getClass().getResource("/icons/icon.png")));
        setContentPane(new GradientPanel());
        setLayout(null);
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel title = new JLabel("Thankyou " + name + " for playing AP Quiz");
        title.setBounds(50, 40, 600, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);
        
        JLabel scoreLbl = new JLabel("Your Score : " + score + " / 100");
        scoreLbl.setBounds(170, 150, 400, 40);
        scoreLbl.setFont(new Font("Segoe UI", Font.BOLD, 28));
        scoreLbl.setForeground(new Color(230, 240, 255));
        scoreLbl.setHorizontalAlignment(JLabel.CENTER);
        add(scoreLbl);
        
        int percent = score;
        JLabel percentLbl = new JLabel("Percentage : " + percent + "%");
        percentLbl.setBounds(180, 210, 400, 35);
        percentLbl.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        percentLbl.setForeground(new Color(220, 240, 255));
        percentLbl.setHorizontalAlignment(JLabel.CENTER);
        add(percentLbl);
        
        String msg;
        if (percent >= 90) msg = "🏆 Excellent!";
        else if (percent >= 70) msg = "👏 Very Good!";
        else if (percent >= 50) msg = "🙂 Good Job!";
        else msg = "💪 Keep Practicing!";
        
        JLabel msgLbl = new JLabel(msg);
        msgLbl.setBounds(180, 260, 400, 40);
        msgLbl.setFont(new Font("Segoe UI Emoji", Font.BOLD, 26));
        msgLbl.setForeground(new Color(255, 220, 120));
        msgLbl.setHorizontalAlignment(JLabel.CENTER);
        add(msgLbl);
        
        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(130, 340, 160, 45);
        styleButton(playAgain);
        add(playAgain);
        
        playAgain.addActionListener(e -> {
            setVisible(false);
            new Login();
        });
        
        JButton leaderboard = new JButton("Leaderboard");
        leaderboard.setBounds(480, 340, 160, 45);
        styleButton(leaderboard);
        add(leaderboard);
        
        leaderboard.addActionListener(e -> {
            new LeaderboardFrame();
        });
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new Score("User", 0);
    }
}