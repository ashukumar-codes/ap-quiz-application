package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener {

    JTextField q, o1, o2, o3, o4, ans;
    JButton add, done, edit, delete;

    JList<String> questionList;
    DefaultListModel<String> listModel;

    AdminPanel() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        getClass().getResource("/icons/icon.png")));
        setContentPane(new GradientPanel());
        setBounds(200, 80, 1000, 650);
        setLayout(null);


        JLabel heading = new JLabel("ADMIN PANEL - MANAGE QUESTIONS");
        heading.setBounds(250, 20, 500, 30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(heading);

        
        q = createField("Enter Question", 80);
        o1 = createField("Option 1", 140);
        o2 = createField("Option 2", 200);
        o3 = createField("Option 3", 260);
        o4 = createField("Option 4", 320);
        ans = createField("Correct Answer", 380);

        
        add = new JButton("Add");
        add.setBounds(150, 450, 120, 40);
        styleButton(add);
        add.addActionListener(this);
        add(add);

        edit = new JButton("Edit");
        edit.setBounds(300, 450, 120, 40);
        styleButton(edit);
        edit.addActionListener(this);
        add(edit);

        delete = new JButton("Delete");
        delete.setBounds(450, 450, 120, 40);
        styleButton(delete);
        delete.addActionListener(this);
        add(delete);

        done = new JButton("Start Quiz");
        done.setBounds(600, 450, 150, 40);
        styleButton(done);
        done.addActionListener(this);
        add(done);

        // LIST MODEL
        listModel = new DefaultListModel<>();

        for (Question qu : QuizData.questions) {
            listModel.addElement(qu.question);
        }

        questionList = new JList<>(listModel);
        questionList.setBounds(650, 80, 300, 300);
        questionList.setBackground(Color.WHITE);
        add(questionList);

        // SELECT EVENT (auto fill fields)
        questionList.addListSelectionListener(e -> {
            int index = questionList.getSelectedIndex();

            if (index != -1) {
                Question qu = QuizData.questions.get(index);

                q.setText(qu.question);
                o1.setText(qu.opt1);
                o2.setText(qu.opt2);
                o3.setText(qu.opt3);
                o4.setText(qu.opt4);
                ans.setText(qu.correct);
            }
        });

        setVisible(true);
    }

    JTextField createField(String text, int y) {
        JLabel l = new JLabel(text);
        l.setBounds(100, y, 200, 30);
        l.setForeground(Color.WHITE);
        add(l);

        JTextField t = new JTextField();
        t.setBounds(300, y, 300, 30);
        add(t);
        return t;
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

        // ADD
        if (e.getSource() == add) {

            Question newQ = new Question(
                    q.getText(),
                    o1.getText(),
                    o2.getText(),
                    o3.getText(),
                    o4.getText(),
                    ans.getText()
            );

            QuizData.questions.add(newQ);
            listModel.addElement(q.getText());

            QuizData.saveToFile();

            JOptionPane.showMessageDialog(this, "Question Added!");

            clearFields();
        }

        // EDIT
        if (e.getSource() == edit) {
            int index = questionList.getSelectedIndex();

            if (index != -1) {
                Question updated = new Question(
                        q.getText(),
                        o1.getText(),
                        o2.getText(),
                        o3.getText(),
                        o4.getText(),
                        ans.getText()
                );

                QuizData.questions.set(index, updated);
                listModel.set(index, q.getText());

                QuizData.saveToFile();

                JOptionPane.showMessageDialog(this, "Question Updated!");
            } else {
                JOptionPane.showMessageDialog(this, "Select question first!");
            }
        }

        // DELETE
        if (e.getSource() == delete) {
            int index = questionList.getSelectedIndex();

            if (index != -1) {
                QuizData.questions.remove(index);
                listModel.remove(index);

                QuizData.saveToFile();

                JOptionPane.showMessageDialog(this, "Deleted!");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Select question first!");
            }
        }

        // START QUIZ
        if (e.getSource() == done) {
            setVisible(false);
            new Quiz("User");
        }
    }

    void clearFields() {
        q.setText("");
        o1.setText("");
        o2.setText("");
        o3.setText("");
        o4.setText("");
        ans.setText("");
    }

    public static void main(String[] args) {
        new AdminPanel();
    }
}