package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileNotFoundException;


public class App extends Application implements IGuiObserver{
    AbstractWorldMap map;
    private Stage stage;
    private Button button;
    private TextField textField;
    private MoveDirection[] directions;



    @Override
    public void start(Stage primaryStage){
        stage = primaryStage;
        stage.setTitle("World");

        showMenu();
        buttonClick();
    }

    private void showMenu() {
        VBox vBox = new VBox();
        Label label = new Label("Type arguments");
        label.setPrefHeight(50);
        textField = new TextField();
        textField.setPrefHeight(50);
        button = new Button("START SIMULATION");
        Label emptySpace = new Label("");
        vBox.getChildren().addAll(label, textField, emptySpace, button);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void buttonClick() {
        button.setOnAction(action -> {
            try {
                if (textField.getText().length() > 0) {
                    OptionsParser optionsParser = new OptionsParser();
                     directions = optionsParser.parse(textField.getText().split(" "));
                }
                map = new GrassField(10);
                Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
                SimulationEngine engine = new SimulationEngine(directions, map, positions);
                updateScene();
                engine.addObserver(this);
                Thread thread = new Thread(engine);
                thread.start();
            }catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        });
    }




    private void updateScene(){
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Label label;
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
                    GuiElementBox guiElementBox;
                    try {
                        guiElementBox = new GuiElementBox(obj, pos);
                    } catch (FileNotFoundException exception) {
                        throw new RuntimeException(exception);
                    }
                    VBox vbox = guiElementBox.getContent();
                    gridPane.add(vbox, i + 1 - xLeft, yRight - j + 1 );
                    GridPane.setHalignment(vbox, HPos.CENTER);
                }
            }
        }

        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void positionChanged() {
        try {
            Platform.runLater(()->{
                updateScene();
                System.out.println("Moved animal");
            });
            Thread.sleep(500);
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
