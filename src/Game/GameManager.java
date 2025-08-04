package Game;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private int rounds;
    private List<Player> players;

    public GameManager(int rounds, List<Player> players) {
        this.rounds = rounds;
        this.players = players;
        Replay.clearHistory();
    }

    public void startGame(Scanner scanner) {
        Game game = new Game(players);

        for (int i = 1; i <= rounds; i++) {
            game.playRound(i, scanner);
            Replay.recordRound(i, players);
        }

        declareWinner();
        askForReplay(scanner);
    }

    private void declareWinner() {
        players.sort(Comparator.comparingInt(Player::getScore));
        System.out.println("\n🏆 Winner: " + players.get(0).getName() + " with score " + players.get(0).getScore());

        System.out.println("\n📊 Final Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore() + " points");
            HighScoreManager.saveScore(player.getName(), player.getScore(), rounds);
        }
    }

    private void askForReplay(Scanner scanner) {
        System.out.print("\n🔄 Would you like to view the replay? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        if (choice.equals("yes")) {
            Replay.showReplay();
        }
    }
}