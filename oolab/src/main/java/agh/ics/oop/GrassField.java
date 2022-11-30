package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int grassAmount){
        while (grasses.size() < grassAmount){
            Vector2d vector2d = generateRandom(grassAmount);
            if (!isOccupied(vector2d)){
                grasses.put(vector2d, new Grass(vector2d));
            }
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object mapObject = super.objectAt(position);
        if (mapObject == null) {
            return grasses.get(position);
        }
        return mapObject;
    }

    private Vector2d generateRandom(int n){
        return new Vector2d((int) (Math.random() * ((Math.sqrt(n*10) + 1))), (int) (Math.random() * (Math.sqrt(n*10) + 1)));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public Vector2d calculateLowerLeft(){
        Vector2d lowLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE); //I prefer to have [0, 0] in my output as  a reference point, here we could build map only with animal position when there is no grass
        Vector2d[] animalsPosition = getAnimals().keySet().toArray(new Vector2d[0]);
        Vector2d[] grassesPosition = getGrasses().keySet().toArray(new Vector2d[0]);
        for (Vector2d vector : animalsPosition) {
            lowLeft = lowLeft.lowerLeft(vector);
        }
        for (Vector2d vector : grassesPosition) {
            lowLeft = lowLeft.lowerLeft(vector);
        }
        return lowLeft;
    }

    public Vector2d calculateUpperRight(){
        Vector2d topRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Vector2d[] animalsPosition = getAnimals().keySet().toArray(new Vector2d[0]);
        Vector2d[] grassesPosition = getGrasses().keySet().toArray(new Vector2d[0]);
        for (Vector2d vector : animalsPosition) {
            topRight = topRight.upperRight(vector);
        }
        for (Vector2d vector : grassesPosition) {
            topRight = topRight.upperRight(vector);
        }
        return topRight;
    }

    public Map<Vector2d, Grass> getGrasses() {
        return grasses;
    }

}


