package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private Map<Vector2d, Grass> grasses = new HashMap<>();
    public GrassField(int grassAmount){
        while (grasses.size() < grassAmount){
            Vector2d vector2d = generateRandom(grassAmount);
            if (!isOccupied(vector2d)){
                grasses.put(vector2d, new Grass(vector2d));
                this.boundries.addPosition(vector2d);
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
        return boundries.getLowerLeft();
    }

    public Vector2d calculateUpperRight(){
        return boundries.getUpperRight();
    }

}


