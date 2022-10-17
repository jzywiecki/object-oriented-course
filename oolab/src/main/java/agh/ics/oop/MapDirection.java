package agh.ics.oop;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public MapDirection next(){
        // ordinal() and values() were mentioned in lecture
        return MapDirection.values()[(ordinal() + 1) % MapDirection.values().length];
    }

    public MapDirection previous(){
        // ordinal() and values() were mentioned in lecture
        return MapDirection.values()[(ordinal() - 1 + MapDirection.values().length) % MapDirection.values().length];
    }

    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case EAST -> "Wschód";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
        };
    }
}
