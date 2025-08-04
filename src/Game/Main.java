package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n🌟=== Welcome to 15from3! ===🌟");
            System.out.println("1️⃣ Start a New Game 🎮");
            System.out.println("2️⃣ How to Play 📜");
            System.out.println("3️⃣ View High Scores 🏆");
            System.out.println("4️⃣ Exit 🚪");
            System.out.print("👉 Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    startNewGame(scanner);
                    break;
                case 2:
                    showInstructions();
                    break;
                case 3:
                    HighScoreManager.displayHighScores();
                    break;
                case 4:
                    System.out.println("👋 Thanks for playing! See you next time!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid option! Please enter a number from 1 to 4.");
            }
        }
        scanner.close();
    }

    private static void startNewGame(Scanner scanner) {
        System.out.println("\n🎲 Starting a new game! 🎲");
        System.out.println("1. Play Against Computer 🤖");
        System.out.println("2. Play With Friends 👥");
        System.out.print("👉 Choose game mode: ");
        
        int modeChoice = scanner.nextInt();
        scanner.nextLine();

        if (modeChoice == 1) {
            playAgainstComputer(scanner);
        } else if (modeChoice == 2) {
            playWithFriends(scanner);
        } else {
            System.out.println("❌ Invalid choice! Returning to main menu.");
        }
    }

    private static void playAgainstComputer(Scanner scanner) {
        System.out.println("\n🤖 You chose to play against the Computer!");
        
        int rounds = getRounds(scanner);
        System.out.print("🧑 Enter your name: ");
        String playerName = scanner.nextLine();

        List<Player> players = new ArrayList<>();
        players.add(new Player(playerName));
        players.add(new Computer("Computer"));

        GameManager gameManager = new GameManager(rounds, players);
        gameManager.startGame(scanner);
    }

    private static void playWithFriends(Scanner scanner) {
        System.out.println("\n👥 You chose to play with friends!");
        
        int rounds = getRounds(scanner);
        List<Player> players = getPlayers(scanner);

        GameManager gameManager = new GameManager(rounds, players);
        gameManager.startGame(scanner);
    }

    private static int getRounds(Scanner scanner) {
        int rounds;
        do {
            System.out.print("🔢 Enter number of rounds (1-5): ");
            rounds = scanner.nextInt();
            scanner.nextLine();
            if (rounds < 1 || rounds > 5) {
                System.out.println("❌ Please enter a number between 1 and 5.");
            }
        } while (rounds < 1 || rounds > 5);
        return rounds;
    }

    private static List<Player> getPlayers(Scanner scanner) {
        List<Player> players = new ArrayList<>();
        int numPlayers;
        
        do {
            System.out.print("👥 Enter number of players (2-6): ");
            numPlayers = scanner.nextInt();
            scanner.nextLine();
            if (numPlayers < 2 || numPlayers > 6) {
                System.out.println("❌ Please enter a number between 2 and 6.");
            }
        } while (numPlayers < 2 || numPlayers > 6);

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("🧑 Enter name for Player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
        return players;
    }

    private static void showInstructions() {
        System.out.println("\n📜 === How to Play 15from3 === 📜");
        System.out.println("🎯 Goal: Create a hand of 3 cards that add up to exactly 15");
        System.out.println("🃏 You start with 5 cards and must remove at least 2");
        System.out.println("🔢 Card values:");
        System.out.println("   - Number cards = face value (2=2, 3=3, etc.)");
        System.out.println("   - Face cards (J, Q, K) = 10 points");
        System.out.println("   - Aces = 1 point");
        System.out.println("🎁 Bonuses:");
        System.out.println("   - All 3 cards same color: -1 point");
        System.out.println("   - All 3 cards same suit: -2 points");
        System.out.println("🏆 Lowest score wins! Perfect score is 0");
    }
}