package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        //given
        String[] input1 = new String[]{};
        MoveDirection[] directions1 = new OptionsParser().parse(input1);
        IWorldMap map1 = new RectangularMap(10, 5);
        Vector2d[] positions1 = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(5,4) };
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        //when
        engine1.run();
        //then
        assertAll(
                () -> assertFalse(map1.canMoveTo(new Vector2d(2, 2))),
                () -> assertFalse(map1.canMoveTo(new Vector2d(3, 4))),
                () -> assertFalse(map1.canMoveTo(new Vector2d(5, 4))),
                () -> assertFalse(map1.canMoveTo(new Vector2d(11, 2))),
                () -> assertTrue(map1.canMoveTo(new Vector2d(1, 1))),
                () -> assertTrue(map1.canMoveTo(new Vector2d(1, 2)))

        );
    }

    @Test
    void place() {
        //given
        String[] input1 = new String[]{};
        MoveDirection[] directions1 = new OptionsParser().parse(input1);
        IWorldMap map1 = new RectangularMap(10, 5);
        Vector2d[] positions1 = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(5,4) };
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        //when
        engine1.run();
        Animal animal1 = new Animal(map1, new Vector2d(2, 2));
        Animal animal2 = new Animal(map1, new Vector2d(3, 3));
        Animal animal3 = new Animal(map1, new Vector2d(4, 4));
        //then
        assertAll(
                () -> assertTrue(map1.place(animal2)),
                () -> assertTrue(map1.place(animal3))
        );
    }

    @Test
    void isOccupied() {
        //given
        String[] input1 = new String[]{};
        MoveDirection[] directions1 = new OptionsParser().parse(input1);
        IWorldMap map1 = new RectangularMap(10, 5);
        Vector2d[] positions1 = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(5,4) };
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        //when
        engine1.run();
        //then
        assertAll(
                () -> assertTrue(map1.isOccupied(new Vector2d(2, 2))),
                () -> assertTrue(map1.isOccupied(new Vector2d(3, 4))),
                () -> assertTrue(map1.isOccupied(new Vector2d(5, 4))),
                () -> assertFalse(map1.isOccupied(new Vector2d(1, 2))),
                () -> assertFalse(map1.isOccupied(new Vector2d(11, 2)))
        );
    }

    @Test
    void objectAt() {
        //given
        String[] input1 = new String[]{};
        MoveDirection[] directions1 = new OptionsParser().parse(input1);
        IWorldMap map1 = new RectangularMap(10, 5);
        Vector2d[] positions1 = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(5,4) };
        MapDirection[] directions_results = {MapDirection.NORTH, MapDirection.NORTH, MapDirection.NORTH};
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        //when
        engine1.run();
        //then
        Animal animal1 = (Animal) map1.objectAt(positions1[0]);
        Animal animal2 = (Animal) map1.objectAt(positions1[1]);
        Animal animal3 = (Animal) map1.objectAt(positions1[2]);
        assertAll(
                () -> assertEquals(animal1.getOrientation(), directions_results[0]),
                () -> assertEquals(animal2.getOrientation(), directions_results[1]),
                () -> assertEquals(animal3.getOrientation(), directions_results[2]),
                () -> assertNull(map1.objectAt(new Vector2d(1, 1)))
        );
    }

}