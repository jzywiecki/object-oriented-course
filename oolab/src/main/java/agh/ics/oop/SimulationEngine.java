package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable{
    private final MoveDirection[] directionsForAnimals;
    private final ArrayList<Animal> animals;
    private final ArrayList<IGuiObserver> observers;


    public SimulationEngine(MoveDirection[] directionsForAnimals, IWorldMap map, Vector2d[] animalsPositions){
        this.directionsForAnimals = directionsForAnimals;
        this.animals = new ArrayList<>();
        this.observers = new ArrayList<>();
        for (Vector2d animalsPosition : animalsPositions) {
            Animal animal = new Animal(map, animalsPosition, MapDirection.NORTH);
            if (map.place(animal)) {
                animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < directionsForAnimals.length; i++){
            Animal animal = animals.get(i % animals.size());
            animal.move(directionsForAnimals[i]);
            try {
                informObserversAboutChanges();
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }

    public void informObserversAboutChanges() throws InterruptedException{
        for (IGuiObserver observer: observers) {
            observer.positionChanged();
        }
    }

    public void addObserver(IGuiObserver observer) {
        observers.add(observer);
    }
}
