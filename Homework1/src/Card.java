public class Card {
    enum Suit {
        heart, spade, club, diamond
    }

    enum Rank {
        A, 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K
    }

    private Rank rank;
    private Suit suit;

    public Card(rank r, suit s){
        this.rank = r;
        this.suit = s;
    }
}
