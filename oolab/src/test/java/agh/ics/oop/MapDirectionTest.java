package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void testNext(){
        assertAll(
                () -> assertEquals(MapDirection.WEST.next(), MapDirection.NORTH),
                () -> assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST),
                () -> assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH),
                () -> assertEquals(MapDirection.NORTH.next(), MapDirection.EAST)
        );
    }
    @Test
    public void previousTest(){
        assertAll(
                () -> assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST),
                () -> assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH),
                () -> assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST),
                () -> assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH)
        );
    }
}
