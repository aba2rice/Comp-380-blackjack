import java.util.ArrayList;
import java.util.List;

/**
 * A concrete class representing all of the hands on the table.
 * Note that the number of other players (the final static field)
 * must be set in order for the constructor to know how to properly
 * read the line of csv.
 */
public class Table {

    /**
     * The number of other players (doesn't include player 1 or the dealer).
     */
    private final static int NUM_OTHER_PLAYERS = 3;

    /**
     * The hands appear in the same order as the csv file.
     * First is the dealer's hand, then the players' hands
     * follow in decreasing order of player number (player 1
     * is last).
     */
    private final List<Hand> hands;

    /**
     * Constructs each hand from a line of csv.
     *
     * @param csvLine a line of csv
     */
    public Table(String csvLine) {
        this.hands = new ArrayList<>();

        int handStartIdx = 1;
        int handEndIdx = findCommaAfter(1, csvLine);

        // Add the dealer's hand.
        this.hands.add(new Hand(csvLine.substring(handStartIdx, handEndIdx)));

        // Add the other players' hands (excluding player 1).
        for (int i = 0; i < NUM_OTHER_PLAYERS; i++) {

            int previousHandEndIdx = handEndIdx;

            // This hand starts after the comma at the end of the previous hand.
            handStartIdx = previousHandEndIdx + 1;

            // Every player who is not player 1 has two cards.
            handEndIdx = findCommaAfter(findCommaAfter(previousHandEndIdx, csvLine), csvLine);

            this.hands.add(new Hand(csvLine.substring(handStartIdx, handEndIdx)));
        }

        // Add player 1's hand. The remaining cards all belong to player 1.
        this.hands.add(new Hand(csvLine.substring(handEndIdx + 1)));
    }

    /**
     * Returns Player 1's hand, which is at the last
     * index in the list of hands.
     *
     * @return Player 1's hand
     */
    public Hand getPlayer1Hand(){
        return this.hands.get(this.hands.size() - 1);
    }

    public Card getDealerCard() {
        return hands.get(0).get(0);
    }

    /**
     * Returns the first index of a comma contained in the input
     * string, where the comma's index is strictly greater than the
     * input index.
     *
     * @param idx an index in the string
     * @param str a string
     * @return the first index of a comma in the input string after the input index
     */
    private static int findCommaAfter(int idx, String str) {
        return idx + 1 + str.substring(idx + 1).indexOf(',');
    }

}
