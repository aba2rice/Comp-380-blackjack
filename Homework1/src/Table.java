import java.util.List;

public class Table {
    /**
     * Player 1 will be the first Hand in the List, player 2 will be the second, and so on.
     * The fifth Hand will be the dealer's hand.
     */
    private List<Hand> hands;

    public Table(String csvLine){
        String[] cardStrings = csvLine.split(",");
        Card[] cards = new Card[9];
        for (int i = 1; i <= 9; i++) {
            cards[i - 1] = new Card(cardStrings[i]);
        }
    }

    public Hand getPlayerHand(){
        return this.hands.get(0);
    }



}
