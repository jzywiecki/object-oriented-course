package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractWorldMap implements IWorldMap {
    public List<Animal> animals = new ArrayList<>();
    public List<Grass> grasses = new ArrayList<>();
    @Override
    public boolean place(Animal animal) {
        if (!(objectAt(animal.getPosition()) instanceof Animal)){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getPosition(), position)) {
                return animal;
            }
        }
        for (Grass grass : grasses) {
            if (Objects.equals(grass.getPosition(), position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(calculateLowerLeft(), calculateUpperRight());
    }

    protected abstract Vector2d calculateUpperRight();

    protected abstract Vector2d calculateLowerLeft();

}
