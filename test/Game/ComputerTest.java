package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;
    private Deck deck;

    @BeforeEach
    void setUp() {
        computer = new Computer("AI Bot");
        deck = new Deck();
    }

    @Test
    void testComputerPlayTurnDrawsUpToThreeCards() {
        computer.getHand().clear();
        deck = new Deck();
        while (!deck.isEmpty()) deck.draw();
        computer.playTurn(deck, new Scanner(System.in));
        assertTrue(computer.getHand().size() <= 3);
    }

    @Test
    void testComputerPlayTurnScoreIncreases() {
        computer.getHand().clear();
        computer.getHand().add(new Card(2, Card.Suit.HEARTS));
        computer.getHand().add(new Card(7, Card.Suit.CLUBS));
        computer.getHand().add(new Card(10, Card.Suit.SPADES));

        int initialScore = computer.getScore();
        computer.playTurn(deck, new Scanner(System.in));
        assertTrue(computer.getScore() > initialScore);
    }

    @Test
    void testFindBestCombinationRemovesTwoCards() {
        computer.getHand().clear();
        computer.getHand().add(new Card(2, Card.Suit.HEARTS));
        computer.getHand().add(new Card(9, Card.Suit.DIAMONDS));
        computer.getHand().add(new Card(5, Card.Suit.CLUBS));
        computer.getHand().add(new Card(11, Card.Suit.SPADES));

        int handSizeBefore = computer.getHand().size();
        computer.playTurn(deck, new Scanner(System.in));
        int handSizeAfter = computer.getHand().size();

        assertTrue(handSizeAfter <= 3 && handSizeAfter >= 1);
    }

    @Test
    void testComputerTurnWithEmptyDeck() {
        while (!deck.isEmpty()) deck.draw();

        computer.getHand().clear();
        computer.getHand().add(new Card(3, Card.Suit.HEARTS));
        computer.getHand().add(new Card(6, Card.Suit.DIAMONDS));
        computer.getHand().add(new Card(8, Card.Suit.CLUBS));
        computer.getHand().add(new Card(1, Card.Suit.SPADES));

        computer.playTurn(deck, new Scanner(System.in));
        assertTrue(computer.getHand().size() <= 3);
    }
}
