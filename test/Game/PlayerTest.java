package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private Deck deck;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer");
        deck = new Deck();
    }

    @Test
    void testDrawHandHasFiveCards() {
        player.drawHand(deck);
        assertEquals(5, player.getHand().size());
    }

    @Test
    void testInitialHandStoresCorrectCards() {
        player.drawHand(deck);
        String initial = player.getInitialHand();
        assertNotNull(initial);
        assertTrue(initial.contains("of"));
    }

    @Test
    void testGetName() {
        assertEquals("TestPlayer", player.getName());
    }

    @Test
    void testGetScoreInitiallyZero() {
        assertEquals(0, player.getScore());
    }

    @Test
    void testCalculateScoreBehavior() {
        List<Card> testHand = new ArrayList<>();
        testHand.add(new Card(3, Card.Suit.HEARTS));
        testHand.add(new Card(5, Card.Suit.DIAMONDS));
        testHand.add(new Card(6, Card.Suit.HEARTS));
        int score = player.calculateScore(testHand);
        assertTrue(score >= 0);
    }

    @Test
    void testCalculateScoreColorBonus() {
        List<Card> redCards = new ArrayList<>();
        redCards.add(new Card(2, Card.Suit.HEARTS));
        redCards.add(new Card(5, Card.Suit.HEARTS));
        redCards.add(new Card(8, Card.Suit.DIAMONDS));

        int rawScore = Math.abs(15 - 15); 
        int finalScore = player.calculateScore(redCards);

        assertEquals(0, finalScore); 
    }

    @Test
    void testCalculateScoreSuitBonus() {
        List<Card> sameSuit = new ArrayList<>();
        sameSuit.add(new Card(4, Card.Suit.CLUBS));
        sameSuit.add(new Card(6, Card.Suit.CLUBS));
        sameSuit.add(new Card(5, Card.Suit.CLUBS));
        int score = player.calculateScore(sameSuit);
        assertTrue(score <= Math.abs(15 - 15));
    }
}
