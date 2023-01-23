import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a player or dealer's hand of cards.
 */
public class Hand {
    /**
     * The list of cards contained in the hand.
     */
    private List<Card> cards;

    /**
     * For initializing one-card (dealer) hand.
     *
     * @param cardUnicode the unicode for the card
     */
    public Hand(String cardUnicode) {
        this.cards = new ArrayList<>();
        this.addCard(cardUnicode);
    }

    /**
     * For initializing two-card (player) hand.
     *
     * @param card1Unicode the unicode for the first card
     * @param card2Unicode the unicode for the second card
     */
    public Hand(String card1Unicode, String card2Unicode) {
        this.cards = new ArrayList<>();
        this.addCard(card1Unicode);
        this.addCard(card2Unicode);
    }

    /**
     * Adds the card to the hand if the cardUnicode is not the empty string.
     *
     * @param cardUnicode the unicode for a card
     */
    private void addCard(String cardUnicode) {
        if (!cardUnicode.isEmpty()) {
            this.cards.add(new Card(cardUnicode));
        }
    }

    /**
     * Returns the hard value of the hand (where ace value is 1)
     * 
     * @return an integer representing the hard value of the hand 
     */
    public int getHard() {
        int total = 0;
        for (Card card: this.cards) {      //iterate through cards in hand
            total += card.getValue() == -1 ? 1 : card.getValue();
        }
        return total;
    }

    /**
     * Returns the soft value of the hand (where ace value is 11)
     * 
     * @return an integer representing the soft value of a hand 
     */
    public int getSoft() {
        int total = 0;
        for (Card card: this.cards) {      //iterate through cards in hand
            total += card.getValue() == -1 ? 11 : card.getValue();
        }
        return total;
    }
}
