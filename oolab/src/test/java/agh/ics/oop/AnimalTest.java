package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void orientationTest(){
        //this test checks if animal has proper orientation
        //given
        String[] inputString1 = new String[]{"r", "r", "r", "r", "r"};
        String[] inputString2 = new String[]{"l", "l", "l", "l", "l"};
        MoveDirection[] input1 = OptionsParser.parse(inputString1);
        MoveDirection[] input2 = OptionsParser.parse(inputString2);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();

        //when
        for (MoveDirection direction: input1){
            animal1.move(direction);
        }
        for (MoveDirection direction: input2){
            animal2.move(direction);
        }
        //then
        assertAll(
                () -> assertEquals(animal1.getOrientation(), MapDirection.EAST),
                () -> assertEquals(animal2.getOrientation(), MapDirection.WEST)
        );


    }

    @Test
    public void positionTest(){
        //this test checks if animal has proper position
        //given
        String[] inputString1 = new String[]{"f", "f", "l", "b", "r", "b"};
        String[] inputString2 = new String[]{"b", "l", "b", "r", "f", "f"};
        MoveDirection[] input1 = OptionsParser.parse(inputString1);
        MoveDirection[] input2 = OptionsParser.parse(inputString2);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();

        //when
        for (MoveDirection direction: input1){
            animal1.move(direction);
        }
        for (MoveDirection direction: input2){
            animal2.move(direction);
        }
        //then
        assertAll(
                () -> assertEquals(animal1.getPosition(), new Vector2d(3, 3)),
                () -> assertEquals(animal2.getPosition(), new Vector2d(3, 3))
        );



    }

    @Test
    public void mapTest(){
        //this test checks if animal can go out of map boundaries
        //given
        String[] inputString1 = new String[]{"f", "f", "f", "r", "f", "f", "f"};
        String[] inputString2 = new String[]{"l", "f", "f", "f", "r", "f", "f", "f"};
        String[] inputString3 = new String[]{"r", "f", "f", "f", "r", "f", "f", "f"};
        String[] inputString4 = new String[]{"b", "b", "b", "l", "f", "f", "f"};
        MoveDirection[] input1 = OptionsParser.parse(inputString1);
        MoveDirection[] input2 = OptionsParser.parse(inputString2);
        MoveDirection[] input3 = OptionsParser.parse(inputString3);
        MoveDirection[] input4 = OptionsParser.parse(inputString4);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        Animal animal4 = new Animal();

        //when
        for (MoveDirection direction: input1){
            animal1.move(direction);
        }
        for (MoveDirection direction: input2){
            animal2.move(direction);
        }
        for (MoveDirection direction: input3){
            animal3.move(direction);
        }
        for (MoveDirection direction: input4){
            animal4.move(direction);
        }

        //then
        assertAll(
                () -> assertEquals(new Vector2d(4, 4), animal1.getPosition()),
                () -> assertEquals(new Vector2d(0, 4), animal2.getPosition()),
                () -> assertEquals(new Vector2d(4, 0), animal3.getPosition()),
                () -> assertEquals(new Vector2d(0, 0), animal4.getPosition())
        );

    }
}
