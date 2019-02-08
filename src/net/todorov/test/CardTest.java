package net.todorov.test;

import net.todorov.Card;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    Card obj;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        obj=new Card(Card.Color.BLACK, Card.Suit.CLUB, Card.Rank.N2, 77);
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        assertEquals(Card.Color.BLACK, obj.getColor());
    }

    @org.junit.jupiter.api.Test
    void getSuit() {
        assertEquals(Card.Suit.CLUB, obj.getSuit());
    }

    @org.junit.jupiter.api.Test
    void getFace() {
        assertEquals(Card.Rank.N2, obj.getRank());
    }

    @org.junit.jupiter.api.Test
    void getRank() {
        assertEquals(77, obj.getWeight());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("(77,N2,BLACK,CLUB)", obj.toString());
    }
}