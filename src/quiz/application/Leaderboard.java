package quiz.application;

import java.io.*;
import java.util.*;

public class Leaderboard {

    private static final String FILE = "leaderboard.dat";

    
    public static void saveScore(String name, int score) {
        List<Player> list = loadScores();
        list.add(new Player(name, score));

        
        list.sort((a, b) -> b.score - a.score);

        
        if (list.size() > 5)
            list = list.subList(0, 5);

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static List<Player> loadScores() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE))) {
            return (List<Player>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    
    public static class Player implements Serializable {
        public String name;
        public int score;

        public Player(String n, int s) {
            name = n;
            score = s;
        }
    }
}