import java.util.ArrayList;
import java.util.List;

/**
 * A concrete class representing all of the hands on the table.
 * Note that this implementation supports any number of players.
 */
public class Table {
    /**
     * The hands appear in the same order as the csv file.
     * First is the dealer's hand, then the players' hands
     * follow in decreasing order of player number (player 1
     * is last).
     */
    private final List<Hand> hands;

    /**
     * Constructs a table from a line of csv. Note that this
     * implementation supports any number of players as long
     * as the dealer's hand appears first and as long as the
     * players' hands follow in decreasing order of player number.
     *
     * @param csvLine a line of csv
     */
    public Table(String csvLine){
        String[] cardUnicodes = csvLine.split(",");

        this.hands = new ArrayList<>();

        /*
         * Add the dealer's hand. The dealer's hand is the
         * string at index 1 because the line of csv starts
         * with a comma (we will write HIT or STAY in front
         * of the comma).
         */
        this.hands.add(new Hand(cardUnicodes[1]));

        // Add the players' hands.
        for (int i = 2; i < cardUnicodes.length; i += 2) {
            this.hands.add(new Hand(cardUnicodes[i],
                                    cardUnicodes[i + 1]));
        }
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



}
