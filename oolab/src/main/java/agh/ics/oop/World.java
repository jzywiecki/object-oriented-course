package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static final Vector2d LOWER_BOUND = new Vector2d(0, 0);
    public static final Vector2d UPPER_BOUND = new Vector2d(4, 4);
    public static MoveDirection[] change(String[] directions){
       MoveDirection[] directions_enum = new MoveDirection[directions.length];
        for (int i = 0; i < directions.length; i++){
            directions_enum[i] = switch(directions[i]){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> MoveDirection.OTHER;
            };
        }
        return directions_enum;
    }
    public static void run(MoveDirection[] directions){
        for(MoveDirection direction: directions){
            switch (direction) {
                case FORWARD  -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT    -> System.out.println("Zwierzak skręca w prawo");
                case LEFT     -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }

    public static void main(String[] args) throws IllegalArgumentException{
        Application.launch(App.class, args);
    }
}
