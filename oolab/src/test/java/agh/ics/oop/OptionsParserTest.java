package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void parserTest(){
        //given
        String[] input = new String[]{"f", "forward", "b", "backward", "r", "right", "l", "left", "ununsept", "right-left", "left-right", "forward"};
        MoveDirection[] expectedOutput = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD};
        //when
        MoveDirection[] output = OptionsParser.parse(input);
        //then
        System.out.println();
        assertArrayEquals(expectedOutput, output);
    }
}
