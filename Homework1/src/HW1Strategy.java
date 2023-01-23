/**
 * COMP 380 - HOMEWORK 1 (Naive Strategy)
 *
 * AUTHORS - Jerome Cerio, Alex Hochstein, Andrew Adams, Sam Yu
 */

/**
 * Class to implement the naive Blackjack strategy of Homework 1.
 */
public class HW1Strategy {

    /**
     * Prepends the decision (HIT or STAY) to the beginning of the
     * line of csv.
     *
     * @param table the table of all hands
     * @param csvLine the line of csv
     * @return the line of csv with the decision inserted in front
     */
    public static String strategy(Table table, String csvLine) {
        return hitOrStay(table) + csvLine;
    }

    /**
     * This method determines the decision if the player should HIT or STAY
     * based off their current hand. The decision is based off the naive
     * strategy of examining the soft and hard value of the player's hand.
     *
     * @param table the table of all hands
     * @return a string in all caps indicating the chosen action
     */
    private static String hitOrStay(Table table){
        Hand hand = table.getPlayer1Hand();
        if (hand.getHard() > 11) {
            return "STAY";
        } else {
            if (hand.getSoft() > 17) {
                return "STAY";
            } else {
                return "HIT";
            }
        }
    }


}
