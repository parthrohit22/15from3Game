package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Computer extends Player {
    public Computer(String name) {
        super(name);
    }

    @Override
    public void playTurn(Deck deck, Scanner scanner) {
        System.out.println("\n" + name + "'s turn!");
        System.out.println("Computer's hand: " + hand);

        List<Card> bestCombination = findBestCombination();
        hand.removeAll(bestCombination);

        while (hand.size() < 3 && !deck.isEmpty()) {
            hand.add(deck.draw());
        }

        int roundScore = calculateScore(hand);
        score += roundScore;
        System.out.println(name + " scored: " + roundScore + " (Total: " + score + ")");
    }

    private List<Card> findBestCombination() {
        List<Card> bestCardsToRemove = new ArrayList<>();
        int bestScore = Integer.MAX_VALUE;

        for (int i = 0; i < hand.size(); i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                List<Card> remaining = new ArrayList<>(hand);
                remaining.remove(i);
                remaining.remove(j - 1);
                
                int currentScore = calculateScore(remaining);
                if (currentScore < bestScore) {
                    bestScore = currentScore;
                    bestCardsToRemove.clear();
                    bestCardsToRemove.add(hand.get(i));
                    bestCardsToRemove.add(hand.get(j));
                }
            }
        }
        return bestCardsToRemove;
    }
}