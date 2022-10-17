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

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.NORTH);
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.NORTH.toUnitVector());

    }
}
