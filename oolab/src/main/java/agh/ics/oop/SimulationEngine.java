package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directionsForAnimals;
    private final IWorldMap map;
    private final ArrayList<Animal> animals;


    public SimulationEngine(MoveDirection[] directionsForAnimals, IWorldMap map, Vector2d[] animalsPositions){
        this.directionsForAnimals = directionsForAnimals;
        this.map = map;
        this.animals = new ArrayList<Animal>();


        for (Vector2d animalsPosition : animalsPositions) {
            Animal animal = new Animal(map, animalsPosition, MapDirection.NORTH);
            if (map.place(animal)) {
                animals.add(animal);
            }
        }
    }


    @Override
    public void run() {
        System.out.println(map.toString()); //map before animals moves
        for (int i = 0; i < directionsForAnimals.length; i++){
            Animal animal = animals.get(i % animals.size());
            animal.move(directionsForAnimals[i]);
            System.out.println(map.toString());
        }
    }
}
