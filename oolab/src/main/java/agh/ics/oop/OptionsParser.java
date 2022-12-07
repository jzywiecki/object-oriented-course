package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] input){
        int countValidInput = 0;
        MoveDirection[] output = new MoveDirection[input.length];
        for (int i = 0; i < input.length; i++){
            switch (input[i]){
                case "forward", "f" -> {
                    output[countValidInput] = MoveDirection.FORWARD;
                    countValidInput += 1;
                }
                case "backward", "b" -> {
                        output[countValidInput] = MoveDirection.BACKWARD;
                        countValidInput += 1;
                }
                case "right", "r" -> {
                    output[countValidInput] = MoveDirection.RIGHT;
                    countValidInput += 1;
                }

                case "left", "l" -> {
                    output[i] = MoveDirection.LEFT;
                    countValidInput += 1;
                }
                default -> {throw new IllegalArgumentException(input[i] + " is not legal move specification.");}
            }

        }

        return Arrays.copyOfRange(output, 0, countValidInput);
    }
}
