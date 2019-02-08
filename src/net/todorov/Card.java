package net.todorov;

import java.util.ArrayList;

public class Card implements Comparable<Card> {
    protected Color color;
    protected Suit suit;
    protected Rank rank;
    private Integer weight;

    public Card(Color color, Suit suit, Rank face, Integer weight) {
        this.color = color;
        this.suit = suit;
        this.rank = face;
        this.weight = weight;
    }

    public Color getColor() {
        return this.color;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    /*
        describes the weight of the card in the sort order
     */
    public Integer getWeight() {
        return this.weight;
    }

    /*
        describes the weight of the card in the doer order
     */
    public String toString() {
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add(this.getWeight().toString());
        tokens.add(this.getRank().toString());
        tokens.add(this.getColor().toString());
        tokens.add(this.getSuit().toString());
        return "("+String.join(",", tokens) + ")";
    }

    @Override
    public int compareTo(Card o) {
        return this.getWeight().compareTo(o.getWeight());
    }

    /*
        There are 2 colors. Source: https://www.thoughtco.com/standard-deck-of-cards-3126599
     */
    public enum Color {
        BLACK, RED;
    }

    /*
        There are  4 suits. Source: https://www.thoughtco.com/standard-deck-of-cards-3126599
     */
    public enum Suit {
        HEART, DIAMOND, SPADE, CLUB;
    }

    /*
        There are 13 ranks per suite. These ranks include the numbers 2 through 10, jack,
        queen, king and ace. Source: https://www.thoughtco.com/standard-deck-of-cards-3126599
     */
    public enum Rank {
        N2, N3, N4, N5, N6, N7, N8, N9, N10, JACK, QUEEN, KING, ACE;
    }
}
