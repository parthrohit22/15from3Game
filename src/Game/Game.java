package Game;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Deck deck;
    private List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
    }

    public void playRound(int roundNum, Scanner scanner) {
        System.out.println("\n--- Round " + roundNum + " ---");
        for (Player player : players) {
            player.drawHand(deck);
            player.playTurn(deck, scanner);
        }
    }
}