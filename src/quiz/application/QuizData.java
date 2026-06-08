package quiz.application;

import java.io.*;
import java.util.ArrayList;

public class QuizData {

    public static ArrayList<Question> questions = new ArrayList<>();

    // SAVE QUESTIONS
    public static void saveToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("questions.dat"));
            oos.writeObject(questions);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LOAD QUESTIONS
    public static void loadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("questions.dat"));
            questions = (ArrayList<Question>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            
        }
    }
}