package agh.ics.oop;

public class Grass{
    final Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public String toString() {
        return "*";
    }
}
