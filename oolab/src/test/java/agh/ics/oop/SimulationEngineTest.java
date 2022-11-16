package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void run() {
        //test sprawdza zachowanie 3 zwierząt dla łańcucha znaków, a na końcu sprawdza czy znajdują się w odpowiednim położeniu i orientacji.
        //given
        String[] input1 = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions1 = new OptionsParser().parse(input1);
        IWorldMap map1 = new RectangularMap(10, 5);
        Vector2d[] positions1 = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(5,4) };
        Vector2d[] positions1_results = { new Vector2d(2,4), new Vector2d(5,4), new Vector2d(9,4) };
        MapDirection[] directions_results = {MapDirection.NORTH, MapDirection.EAST, MapDirection.EAST};
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        //when
        engine1.run();
        //then
        Animal animal1 = (Animal) map1.objectAt(positions1_results[0]);
        Animal animal2 = (Animal) map1.objectAt(positions1_results[1]);
        Animal animal3 = (Animal) map1.objectAt(positions1_results[2]);
        assertAll(
                () -> assertEquals(animal1.getOrientation(), directions_results[0]),
                () -> assertEquals(animal2.getOrientation(), directions_results[1]),
                () -> assertEquals(animal3.getOrientation(), directions_results[2])
        );


    }
}