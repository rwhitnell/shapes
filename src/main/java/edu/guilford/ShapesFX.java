package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ShapesFX extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // shapePane is where we draw the shapes
        ShapePane shapePane = new ShapePane();
        // shapeList is where we build the list of shapes we'll draw
        ShapeList shapeList = new ShapeList(640, 480);
        shapePane.setShapeList(shapeList);
        shapePane.addShapes();

        // add all the shapes in shapeList to shapePane
        // for (Shape shape : shapeList) {
        //     shapePane.addShape(shape);
        // }

        scene = new Scene(shapePane, 800, 600);
        stage.setScene(scene);
        stage.show();

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            shapeList.setWidth(newVal.intValue());
            shapePane.drawShapes();
        });

        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            shapeList.setHeight(newVal.intValue());
            shapePane.drawShapes();
        });



        Stage controlStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("control.fxml"));
        Parent root = loader.load();
        ControlController controlController = loader.getController();
        controlController.setShapePane(shapePane);
        Scene controlScene = new Scene(root, 300, 200);
        controlStage.setScene(controlScene);
        controlStage.show();


        System.out.println(shapeList);
    }


    public static void main(String[] args) {
        launch();
    }

}