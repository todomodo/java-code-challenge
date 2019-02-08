package net.todorov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {

    public enum SortType {
        ASC, DESC;
    }

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();

        /*
         Initialize the desk by creating 4 suites of cards, 13 ranks each
         */
        AddRanks(Card.Color.BLACK, Card.Suit.CLUB, this.cards);
        AddRanks(Card.Color.BLACK, Card.Suit.SPADE, this.cards);
        AddRanks(Card.Color.RED, Card.Suit.DIAMOND, this.cards);
        AddRanks(Card.Color.RED, Card.Suit.HEART, this.cards);
    }

    public void sort(SortType sortType) {
        Collections.sort(this.cards);
        if (sortType == SortType.DESC) {
            Collections.reverse(this.cards);
        }
    }

    public void shuffle(int shuffleCount) {
        for (int i = 0; i < shuffleCount; i++) {
            int index1 = ThreadLocalRandom.current().nextInt(0, cards.size());
            int index2 = ThreadLocalRandom.current().nextInt(0, cards.size());
            this.swap(index1, index2);
        }
    }

    private void swap(int index1, int index2) {
        Card card = this.cards.get(index1);
        this.cards.set(index1, this.cards.get(index2));
        this.cards.set(index2, card);
    }

    public int size() {
        return this.cards.size();
    }

    public String toString() {
        return this.toString(",");
    }

    public String toString(String delimiter) {
        ArrayList<String> tokens = new ArrayList<>();
        for (Card card : this.cards) {
            tokens.add(card.toString());
        }
        return String.join(delimiter, tokens);
    }


    private static void AddRanks(Card.Color color, Card.Suit suit, ArrayList<Card> cards) {
        for (Card.Rank rank : Card.Rank.values()) {
            /*
                The weight of the card is defined by its place in the array when it's first
                initialized
            */
            int weight = cards.size();
            cards.add(new Card(color, suit, rank, weight));
        }
    }
}
