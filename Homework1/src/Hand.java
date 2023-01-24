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
     * Returns the hard value of the hand (where ace value is 1)
     * 
     * @return an integer representing the hard value of the hand 
     */
    public int getHard() {
        int total = 0;
        for (Card card: this.cards) {      //iterate through cards in hand
            total += (card.getValue() == -1) ? 1 : card.getValue();
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
            total += (card.getValue() == -1) ? 11 : card.getValue();
        }
        return total;
    }
}
