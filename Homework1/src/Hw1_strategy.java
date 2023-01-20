/**
 * COMP 380 - HOMEWORK 1 (Naive Strategy)
 *
 * AUTHORS - Jerome Cerio, Alex Hochstein, Andrew Adams, Sam Yu
 */

/**
 * Class to implement the naive Blackjack strategy of Homework 1.
 */
public class Hw1_strategy {

    public static String strategy(String csvLine) {

    }

    /**
     * This method determines the decision if the player should HIT or STAY
     * based off their current hand. The decision is based off the naive
     * strategy of examining the soft and hard value of the player's hand.
     *
     * @return True if the player should hit, false if the player should stay.
     */
    public boolean hitOrStay(){
        Hand hand = this.table.getPlayerHand();
        if(hand.getHard() > 11){
            return false;
        } else if(hand.getSoft() > 17) {
            return false;
        }
        return true;
    }


}
