import java.util.Map;

/**
 * This class represents a single card from a deck of cards.
 */
public class Card {

    /**
     * Defines the possible suits of a card.
     */
    private enum Suit {
        hearts, spades, clubs, diamonds
    }

    /**
     * Defines the possible ranks of a card.
     */
    private enum Rank {
        ace, two, three, four, five, six, seven, eight, nine, ten, jack, queen, king
    }

    /**
     * The suit of the card
     */
    private final Suit suit;

    /**
     * The rank of the card
     */
    private final Rank rank;

    /**
     * Mapping of each rank to its respective numerical value.
     * The only exception is ace, which is given a flagged value of -1.
     */
    private final Map<Rank, Integer> values = Map.ofEntries(
            Map.entry(Rank.ace, -1),
            Map.entry(Rank.two, 2),
            Map.entry(Rank.three, 3),
            Map.entry(Rank.four, 4),
            Map.entry(Rank.five, 5),
            Map.entry(Rank.six, 6),
            Map.entry(Rank.seven, 7),
            Map.entry(Rank.eight, 8),
            Map.entry(Rank.nine, 9),
            Map.entry(Rank.ten, 10),
            Map.entry(Rank.jack, 10),
            Map.entry(Rank.queen, 10),
            Map.entry(Rank.king, 10));

    /**
     * Constructor to make a new card from its unicode value.
     *
     * @param unicode String holding the unicode value of the card
     *                to be created.
     */
    public Card(String unicode) {

        // Ensure uppercase letters are used for the map.
        unicode = unicode.toUpperCase();

        char suitIndicator = unicode.charAt(3);
        char rankIndicator = unicode.charAt(4);

        /*
         * These initial values of null are required since the
         * compiler can't guarantee the suit and rank will be
         * initialized in the switch statements below. If a card's
         * suit or rank ever are null, that indicates an error.
         */
        Suit suit = null;
        Rank rank = null;

        // Set the card's suit.
        switch (suitIndicator) {
            case 'A' -> suit = Suit.spades;
            case 'B' -> suit = Suit.hearts;
            case 'C' -> suit = Suit.diamonds;
            case 'D' -> suit = Suit.clubs;
        }

        // Set the card's rank.
        switch (rankIndicator) {
            case '1' -> rank = Rank.ace;
            case '2' -> rank = Rank.two;
            case '3' -> rank = Rank.three;
            case '4' -> rank = Rank.four;
            case '5' -> rank = Rank.five;
            case '6' -> rank = Rank.six;
            case '7' -> rank = Rank.seven;
            case '8' -> rank = Rank.eight;
            case '9' -> rank = Rank.nine;
            case 'A' -> rank = Rank.ten;
            case 'B' -> rank = Rank.jack;
            case 'D' -> rank = Rank.queen;
            case 'E' -> rank = Rank.king;
        }

        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Returns the suit of the card.
     *
     * @return a Suit type.
     */
    public Suit getSuit(){
        return this.suit;
    }

    /**
     * Returns the rank of the card.
     *
     * @return a Rank type.
     */
    public Rank getRank(){
        return this.rank;
    }

    /**
     * Returns the numerical value of the card, according to its rank.
     *
     * @return an integer representing the value of the card.
     */
    public int getValue() {
        return values.get(this.rank);
    }
}
