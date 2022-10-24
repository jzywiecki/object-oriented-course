package agh.ics.oop;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    public Animal(){
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Kierunek: " + orientation + ", pozycja: " + position + ".";
    }

    boolean isAt(Vector2d positionToCheck){
        return this.position.x == positionToCheck.x && this.position.y == positionToCheck.y;
    }

    public void move(MoveDirection direction){
        //Forward or Backward movement
        Vector2d added = this.orientation.toUnitVector();
        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                if (position.x + added.x <= 4 && position.x + added.x >= 0 && position.y + added.y <= 4 && position.y + added.y >= 0){
                    position = new Vector2d(position.x + added.x, position.y + added.y);
                }
            }
            case BACKWARD -> {
                if (position.x - added.x <= 4 && position.x - added.x >= 0 && position.y - added.y <= 4 && position.y - added.y >= 0){
                    position = new Vector2d(position.x - added.x, position.y - added.y);
                }
            }

        }

    }
}
