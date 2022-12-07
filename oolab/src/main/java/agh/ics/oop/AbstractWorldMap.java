package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    private Map<Vector2d, Animal> animals = new HashMap<>();
    MapBoundary boundries = new MapBoundary();
    @Override
    public boolean place(Animal animal) {
        if (!(objectAt(animal.getPosition()) instanceof Animal)){
            animals.put(animal.getPosition(), animal);
            boundries.addPosition(animal.getPosition());
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition().toString() + " is invalid to place an animal!");
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = getAnimals().get(oldPosition);
        getAnimals().remove(oldPosition);
        getAnimals().put(newPosition, animal);
        boundries.positionChanged(oldPosition, newPosition);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(calculateLowerLeft(), calculateUpperRight());
    }

    public abstract Vector2d calculateUpperRight();

    public abstract Vector2d calculateLowerLeft();


    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }
}
