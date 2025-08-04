package Game;

import java.util.ArrayList;
import java.util.List;

public class Replay {
    private static List<String> roundHistory = new ArrayList<>();

    public static void recordRound(int round, List<Player> players) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n🔄 Round ").append(round).append(" Summary:");
        for (Player player : players) {
            sb.append("\n").append(player.getName()).append(":")
              .append("\n  Initial Hand: ").append(player.getInitialHand())
              .append("\n  Final Hand: ").append(player.getHand())
              .append("\n  Round Score: ").append(player.getScore());
        }
        roundHistory.add(sb.toString());
    }

    public static void showReplay() {
        if (roundHistory.isEmpty()) {
            System.out.println("📜 No replay data available.");
            return;
        }
        
        System.out.println("\n📜 === Game Replay ===");
        for (String round : roundHistory) {
            System.out.println(round);
        }
    }

    public static void clearHistory() {
        roundHistory.clear();
    }
}