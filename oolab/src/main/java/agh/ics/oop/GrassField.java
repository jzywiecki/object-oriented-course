package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrassField extends AbstractWorldMap{
    private final MapVisualizer mapVisualizer;

    public GrassField(int grassAmount){
        this.mapVisualizer = new MapVisualizer(this);
        while (grasses.size() < grassAmount){
            Vector2d vector2d = generateRandom(grassAmount);
            if (!isOccupied(vector2d)){
                grasses.add(new Grass(vector2d));
            }
        }
    }

    private Vector2d generateRandom(int n){
        return new Vector2d((int) (Math.random() * ((Math.sqrt(n*10) + 1))), (int) (Math.random() * (Math.sqrt(n*10) + 1)));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    public Vector2d calculateLowerLeft(){
        Vector2d lowLeft = new Vector2d(0,0); //I prefer to have [0, 0] in my output as  a reference point, here we could build map only with animal position when there is no grass
        for (Animal animal : animals) {
            lowLeft = lowLeft.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grasses) {
            lowLeft = lowLeft.lowerLeft(grass.getPosition());
        }
        return lowLeft;
    }

    public Vector2d calculateUpperRight(){
        Vector2d topRight = new Vector2d(0,0);
        for (Animal animal : animals) {
            topRight = topRight.upperRight(animal.getPosition());
        }
        for (Grass grass : grasses) {
            topRight = topRight.upperRight(grass.getPosition());
        }
        return topRight;
    }
}
