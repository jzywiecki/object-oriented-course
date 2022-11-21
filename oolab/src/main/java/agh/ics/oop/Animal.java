package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();
    public Animal(IWorldMap map){
        this(map, new Vector2d(2, 2), MapDirection.NORTH);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this(map, new Vector2d(initialPosition.x, initialPosition.y), MapDirection.NORTH);
        addObserver((IPositionChangeObserver) map);
    }

    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection orientation){
        //here we can fully customise our animal.
        //I did not limit position of animal here, we will check it before adding to the map at the end
        this.map = map;
        this.position = new Vector2d(initialPosition.x, initialPosition.y);
        this.orientation = orientation;
        addObserver((IPositionChangeObserver) map);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        //arrows look better :)
        return switch (orientation){
            case NORTH -> "↑";
            case EAST -> "→";
            case SOUTH -> "↓";
            case WEST -> "←";
        };
    }

    public boolean isAt(Vector2d positionToCheck){
        return Objects.equals(this.position, positionToCheck);
    }

    public void move(MoveDirection direction){
        //Forward or Backward movement, there is no need to check if MoveDirection direction is OTHER
        Vector2d orientationVector = this.orientation.toUnitVector();
        Vector2d newPosition = new Vector2d(position.x, position.y);
        Vector2d oldPosition = new Vector2d(position.x, position.y);
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> newPosition = newPosition.add(orientationVector);
            case BACKWARD -> newPosition = newPosition.subtract(orientationVector);
        }
        if (this.map.canMoveTo(newPosition)) {
            this.position = newPosition;
            positionChanged(oldPosition, newPosition);
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
