package net.todorov.test;

import net.todorov.Deck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeskTest {

    Deck obj;
    String sortedTextAsc;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        sortedTextAsc = "(0,N2,BLACK,CLUB),(1,N3,BLACK,CLUB),(2,N4,BLACK,CLUB),(3,N5,BLACK,CLUB),(4,N6,BLACK,CLUB)" +
                ",(5,N7,BLACK,CLUB),(6,N8,BLACK,CLUB),(7,N9,BLACK,CLUB),(8,N10,BLACK,CLUB),(9,JACK,BLACK,CLUB)" +
                ",(10,QUEEN,BLACK,CLUB),(11,KING,BLACK,CLUB),(12,ACE,BLACK,CLUB),(13,N2,BLACK,SPADE)" +
                ",(14,N3,BLACK,SPADE),(15,N4,BLACK,SPADE),(16,N5,BLACK,SPADE),(17,N6,BLACK,SPADE)" +
                ",(18,N7,BLACK,SPADE),(19,N8,BLACK,SPADE),(20,N9,BLACK,SPADE),(21,N10,BLACK,SPADE)" +
                ",(22,JACK,BLACK,SPADE),(23,QUEEN,BLACK,SPADE),(24,KING,BLACK,SPADE),(25,ACE,BLACK,SPADE)" +
                ",(26,N2,RED,DIAMOND),(27,N3,RED,DIAMOND),(28,N4,RED,DIAMOND),(29,N5,RED,DIAMOND)" +
                ",(30,N6,RED,DIAMOND),(31,N7,RED,DIAMOND),(32,N8,RED,DIAMOND),(33,N9,RED,DIAMOND)" +
                ",(34,N10,RED,DIAMOND),(35,JACK,RED,DIAMOND),(36,QUEEN,RED,DIAMOND),(37,KING,RED,DIAMOND)" +
                ",(38,ACE,RED,DIAMOND),(39,N2,RED,HEART),(40,N3,RED,HEART),(41,N4,RED,HEART),(42,N5,RED,HEART)" +
                ",(43,N6,RED,HEART),(44,N7,RED,HEART),(45,N8,RED,HEART),(46,N9,RED,HEART),(47,N10,RED,HEART)" +
                ",(48,JACK,RED,HEART),(49,QUEEN,RED,HEART),(50,KING,RED,HEART),(51,ACE,RED,HEART)";

        obj = new Deck();
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(52, obj.size());
    }

    @org.junit.jupiter.api.Test
    void testSorting() {
        final int SHUFFLE_COUNT=1000;
        obj.shuffle(SHUFFLE_COUNT);
        obj.sort(Deck.SortType.ASC);
        assertEquals(sortedTextAsc, obj.toString());
    }


    @org.junit.jupiter.api.Test
    void testActualShuffle() {
        final int SHUFFLE_COUNT=1000;
        obj.shuffle(SHUFFLE_COUNT);
        assertNotEquals(sortedTextAsc, obj.toString());
    }

    @org.junit.jupiter.api.Test
    void testRepeatedZeroShuffles() {

        final int SHUFFLE_COUNT=100;
        for (int i=0; i<SHUFFLE_COUNT; i++) {
            String before = obj.toString();
            obj.shuffle(0);
            assertEquals(before, obj.toString());
        }
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals(sortedTextAsc, obj.toString());
    }
}