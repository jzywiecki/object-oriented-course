package agh.ics.oop;

public class World {
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

    public static void main(String[] args){
        System.out.println("System wystartował");
        Animal animal = new Animal();
        System.out.println(animal);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal);

        for (MoveDirection direction: OptionsParser.parse(args)){
            animal.move(direction);
            System.out.println(direction);
        }
        System.out.println(animal);
        System.out.println("System zakończył działanie");
    }
}
