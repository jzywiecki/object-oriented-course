package agh.ics.oop;

public class World {
    public static Direction[] change(String[] directions){
        Direction[] directions_enum = new Direction[directions.length];
        for (int i = 0; i < directions.length; i++){
            directions_enum[i] = switch(directions[i]){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.OTHER;
            };
        }
        return directions_enum;
    }
    public static void run(Direction[] directions){
        for(Direction direction: directions){
            switch (direction) {
                case FORWARD  -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT    -> System.out.println("Zwierzak skręca w prawo");
                case LEFT     -> System.out.println("Zwierzak skręca w lewo");
            }
        }

    }

    public static void main(String[] args){
        System.out.println("System wystartował");
        Direction[] directions = change(args);
        run(directions);
        System.out.println("System zakończył działanie");
    }
}
