package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {
    AbstractWorldMap map;

    @Override
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Label label = new Label("Zwierzak");
        Scene scene = new Scene(gridPane, 600, 600);
        int xLeft = map.calculateLowerLeft().x;
        int xRight = map.calculateUpperRight().x;
        int yLeft = map.calculateLowerLeft().y;
        int yRight = map.calculateUpperRight().y;
        Label xy = new Label("y/x");
        gridPane.add(xy, 0, 0);
        gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        gridPane.getRowConstraints().add(new RowConstraints(40));
        gridPane.setHalignment(xy, HPos.CENTER);

        int index = 1;
        for(int i = xLeft; i <= xRight; i++){
            label = new Label(String.valueOf(i));
            gridPane.add(label, index, 0);
            gridPane.getColumnConstraints().add(new ColumnConstraints(40));
            gridPane.setHalignment(label, HPos.CENTER);
            index += 1;
        }

        index = 1;
        for(int i = yLeft; i <= yRight; i++){
            label = new Label(Integer.toString(yRight+yLeft-i));
            gridPane.add(label, 0, index);
            gridPane.getRowConstraints().add(new RowConstraints(40));
            gridPane.setHalignment(label, HPos.CENTER);
            index += 1;
        }

        for(int i = xLeft; i <= xRight; i++){
            for(int j = yRight; j >= yLeft; j--){
                Vector2d pos = new Vector2d(i, j);
                if (map.isOccupied(pos)){
                    var obj = map.objectAt(pos);
                    label = new Label(obj.toString());

                    gridPane.add(label, i + 1 - xLeft, yRight - j + 1 );
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws IllegalArgumentException {
        try {
            List<String> list = getParameters().getRaw();
            String[] array = new String[list.size()];
            for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
            MoveDirection[] directions = new OptionsParser().parse(array);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

        }catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }
    }
}
