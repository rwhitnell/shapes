package edu.guilford;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class ControlController {

    private ShapePane shapePane;

    @FXML
    Slider countSlider;

    public void setShapePane(ShapePane shapePane) {
        this.shapePane = shapePane;
    }

    @FXML
    private void clearShapes() {
        shapePane.clearShapes();
    }

    @FXML
    private void readSlider() {
        int nShapes = (int) countSlider.getValue();
        System.out.println(nShapes);
        shapePane.clearShapes();
 //       shapePane.setShapeList(new ShapeList());
        shapePane.getShapeList().clear();
        shapePane.getShapeList().addShapes(nShapes);
        shapePane.addShapes();
    }

}
