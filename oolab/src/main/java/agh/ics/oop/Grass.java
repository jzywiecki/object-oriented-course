package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Grass{
    final Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String toString() {
        return "*";
    }
}
