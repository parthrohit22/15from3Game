package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testGetValue() {
        Card c1 = new Card(2, Card.Suit.HEARTS);
        Card c2 = new Card(11, Card.Suit.SPADES);
        Card c3 = new Card(13, Card.Suit.CLUBS);
        assertEquals(2, c1.getValue());
        assertEquals(10, c2.getValue());
        assertEquals(10, c3.getValue());
    }

    @Test
    void testIsRed() {
        Card redCard1 = new Card(5, Card.Suit.HEARTS);
        Card redCard2 = new Card(8, Card.Suit.DIAMONDS);
        Card blackCard = new Card(9, Card.Suit.SPADES);
        assertTrue(redCard1.isRed());
        assertTrue(redCard2.isRed());
        assertFalse(blackCard.isRed());
    }

    @Test
    void testToString() {
        Card card = new Card(1, Card.Suit.SPADES);
        assertEquals("A of SPADES", card.toString());

        card = new Card(12, Card.Suit.CLUBS);
        assertEquals("Q of CLUBS", card.toString());
    }

    @Test
    void testSuitEnum() {
        assertNotNull(Card.Suit.valueOf("HEARTS"));
        assertNotNull(Card.Suit.valueOf("DIAMONDS"));
        assertNotNull(Card.Suit.valueOf("CLUBS"));
        assertNotNull(Card.Suit.valueOf("SPADES"));
    }
}
