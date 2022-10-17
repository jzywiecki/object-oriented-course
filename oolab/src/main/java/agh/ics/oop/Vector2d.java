package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;


    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean precedes(Vector2d other){
        return (this.x <= other.x && this.y <= other.y);
    }

    public boolean follows(Vector2d other){
        return (this.x >= other.x && this.y >= other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y); //we can also use x instead of this.x
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }


    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d compared = (Vector2d) other;
        return (compared.x == this.x && compared.y == this.y);
    }

    @Override
    public int hashCode() {
        //"pattern as Josh Bloch suggests in Effective Java" ~ Stackoverflow.
        int hash = 17;
        hash = hash * 31 + this.x;
        hash = hash * 31 + this.y;
        return hash;
    }

    @Override
    public String toString() {
        return "(%d,%d)".formatted(x, y);
    }
}

