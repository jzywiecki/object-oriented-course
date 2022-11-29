package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class exceptionsTest {
    @Test
    public void parserExceptionTest() {
        //given
        String[] input = new String[] {"r", "z"};
        String expectedMessage = "is not legal move specification.";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(input);
        });
        //then
        assert exception.getMessage().contains(expectedMessage);
    }

    @Test
    public void placeExceptionText(){
        //given
        String expectedMessage = "is invalid to place an animal!";
        String[] input1 = new String[]{};
        MoveDirection[] directions1 = new OptionsParser().parse(input1);
        IWorldMap map1 = new RectangularMap(10, 5);
        Vector2d[] positions1 = { new Vector2d(2,2)};
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        //when
        engine1.run();
        Animal animal1 = new Animal(map1, new Vector2d(2, 2));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            map1.place(animal1);
        });
        //then
        assert exception.getMessage().contains(expectedMessage);
    }
}
