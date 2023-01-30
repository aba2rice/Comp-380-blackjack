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
     * Constructs each card from a line of csv.
     *
     * @param csvLine a line of csv
     */
    public Hand(String csvLine) {
        this.cards = new ArrayList<>();
        for (String cardUnicode : csvLine.split(",")) {
            // If the card unicode is the empty string, there is no card to add.
            if (!cardUnicode.isEmpty()) {
                this.cards.add(new Card(cardUnicode));
            }
        }
    }

    /**
     * Returns the hard value of the hand, where all aces are
     * counted as having a value of 1.
     * 
     * @return an integer representing the hard value of the hand 
     */
    public int getHard() {
        int total = 0;
        for (Card card: this.cards) {      //iterate through cards in hand
            total += card.hardValue();
        }
        return total;
    }

    /**
     * Returns the soft value of the hand, where if the hand has at
     * least one ace, then one of the aces is counted as 11, and the
     * other aces are counted as 1.
     * 
     * @return an integer representing the soft value of a hand 
     */
    public int getSoft() {
        // Adds ten to the total if the hand contains at least one ace.
        return this.getHard() + (this.containsAce() ? 10 : 0);
    }

    private boolean containsAce() {
        for (Card card : this.cards) {
            if (card.isAce()) {
                return true;
            }
        }
        return false;
    }

}
