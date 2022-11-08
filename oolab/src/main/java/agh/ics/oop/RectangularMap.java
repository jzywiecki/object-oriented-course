package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int height;
    private final List<Animal> animals;
    private final MapVisualizer mapVisualizer;



    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(width-1, height-1)) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getPosition(), position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getPosition(), position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(new Vector2d(0,0), new Vector2d(width-1, height-1));
    }
}
