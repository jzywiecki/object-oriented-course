package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;

    private final MapVisualizer mapVisualizer;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(width-1, height-1)) && !isOccupied(position);
    }

    public Vector2d calculateLowerLeft(){
        return new Vector2d(0,0);
    }

    public Vector2d calculateUpperRight(){
        return new Vector2d(width-1, height-1);
    }
}
