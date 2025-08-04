package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighScoreManager {
    private static final String FILE_NAME = "Highscores.txt";

    public static void saveScore(String playerName, int totalScore, int rounds) {
        double finalScore = Math.round((double) totalScore / rounds * 100.0) / 100.0;
        String entry = finalScore + " " + playerName;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(entry);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    public static void displayHighScores() {
        List<String> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scores.add(line);
            }
        } catch (IOException e) {
            System.out.println("⚠️ No high scores recorded yet.");
            return;
        }

        scores.sort(Comparator.comparingDouble(s -> Double.parseDouble(s.split(" ")[0])));
        System.out.println("\n🏆 High Scores:");
        int count = Math.min(5, scores.size());
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + scores.get(i));
        }
    }
}