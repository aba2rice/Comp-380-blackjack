import java.util.List;
import java.util.Map;

/**
 * This class represents a player or dealer's hand of cards.
 */
public class Hand {
    /**
     * The list of cards contained in the hand.
     */
    private List<Card> hand;

    /**
     * Constructor for a hand object.
     *
     * @param hand a List of Cards to become the hand.
     */
    public Hand(List<Card> hand){
        this.hand = hand;
    }

    /**
     * Returns the hard value of the hand (where ace value is 1)
     * 
     * @return an integer representing the hard value of the hand 
     */
    public int getHard() {
        int total = 0;
        for(Card card: this.hand){      //iterate through cards in hand
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
        for (Card card: this.hand) {      //iterate through cards in hand
            total += card.getValue() == -1 ? 11 : card.getValue();
        }
        return total;
    }
}
