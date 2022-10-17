package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void testEquals(){
        // IntelliJ suggests using assertEquals, but I wanted to show manifestly that I'm using equal function
        assertAll("Should return if vectors are equal",
                () -> assertTrue(new Vector2d(2, 3).equals(new Vector2d(2, 3))),
                () -> assertFalse(new Vector2d(2, 3).equals(new Vector2d(3, 2)))
        );

    }

    @Test
    public void testToString(){
        assertEquals(new Vector2d(2,3).toString(), "(2,3)");

    }

    @Test
    public void testPrecedes(){
        assertAll(
                () -> assertTrue(new Vector2d(2,3).precedes(new Vector2d(2, 3))),
                () -> assertFalse(new Vector2d(2,11).precedes(new Vector2d(10, 10))),
                () -> assertFalse(new Vector2d(11,2).precedes(new Vector2d(10, 10))),
                () -> assertFalse(new Vector2d(4, 4).precedes(new Vector2d(2, 3)))
        );
    }

    @Test
    public void testFollows(){
        assertAll(
                () -> assertFalse(new Vector2d(1, 2).follows(new Vector2d(2, 3))),
                () -> assertFalse(new Vector2d(2,11).follows(new Vector2d(10, 10))),
                () -> assertTrue(new Vector2d(11,10).follows(new Vector2d(10, 10))),
                () -> assertTrue(new Vector2d(4, 4).follows(new Vector2d(2, 3)))
        );
    }

    @Test
    public void testUpperRight(){
        assertEquals(new Vector2d(2, 3).upperRight(new Vector2d(3, 4)), new Vector2d(3, 4));
    }

    @Test
    public void testLowerLeft(){
        assertEquals(new Vector2d(2, 3).lowerLeft(new Vector2d(3, 4)), new Vector2d(2, 3));
    }

    @Test
    public void testAdd(){
        assertAll(
                () -> assertEquals(new Vector2d(2, 3).add(new Vector2d(3, 2)), new Vector2d(5, 5)),
                () -> assertEquals(new Vector2d(2, 3).add(new Vector2d(-2, -3)), new Vector2d(0, 0)),
                () -> assertEquals(new Vector2d(-2, -3).add(new Vector2d(-1, -2)), new Vector2d(-3, -5))
        );
    }

    @Test
    public void testSubtract(){
        assertAll(
                () -> assertEquals(new Vector2d(2, 3).subtract(new Vector2d(2, 3)), new Vector2d(0, 0)),
                () -> assertEquals(new Vector2d(0, 3).subtract(new Vector2d(3, 2)), new Vector2d(-3, 1)),
                () -> assertEquals(new Vector2d(-2, -3).subtract(new Vector2d(-2, -3)), new Vector2d(0, 0))
        );
    }

    @Test
    public void testOpposite(){
        assertAll(
                () -> assertEquals(new Vector2d(2, 3).opposite(), new Vector2d(-2, -3)),
                () -> assertEquals(new Vector2d(0, 0).opposite(), new Vector2d(0, 0)),
                () -> assertEquals(new Vector2d(-3, 3).opposite(), new Vector2d(3, -3))
        );
    }
}
