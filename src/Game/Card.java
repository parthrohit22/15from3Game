package Game;

public class Card {
    public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}

    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue() {
        if (rank >= 10) return 10;
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isRed() {
        return suit == Suit.HEARTS || suit == Suit.DIAMONDS;
    }

    @Override
    public String toString() {
        String[] rankNames = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        return rankNames[rank - 1] + " of " + suit;
    }
}