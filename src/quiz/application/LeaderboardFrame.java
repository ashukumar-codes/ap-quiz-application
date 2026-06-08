package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LeaderboardFrame extends JFrame {

    LeaderboardFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        getClass().getResource("/icons/icon.png")));
        setTitle("Leaderboard");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setContentPane(new GradientPanel());
        setLayout(new BorderLayout());

        JLabel title = new JLabel("🏆 Leaderboard", JLabel.CENTER);
        title.setFont(new Font("Segoe UI Emoji", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        JPanel listPanel = new JPanel();
        listPanel.setOpaque(false);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        List<Leaderboard.Player> scores = Leaderboard.loadScores();

        int rank = 1;
        for (Leaderboard.Player p : scores) {
            JLabel lbl = new JLabel(
                    rank + ". " + p.name + "  -  " + p.score);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
            lbl.setForeground(Color.WHITE);
            lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPanel.add(lbl);
            rank++;
        }

        add(listPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}