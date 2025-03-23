package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

// ShapeList is a list of Shapes, so let's have it extend ArrayList<Shape>
public class ShapeList extends ArrayList<Shape> {
    // Instantiate a Random object
    private Random random = new Random();
    private int nShapes;
    private int width;
    private int height;

    // Method to return a random Color with any possible value
    public Color getRandomColor() {
        // return a random Color with any possible value
        // this returns a Color with random decimal values for red, green, blue, and
        // alpha (opacity)
        // between 0 and 1
        return Color.color(random.nextDouble(), random.nextDouble(),
                random.nextDouble(), random.nextDouble());
    }

    public ShapeList(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        nShapes = random.nextInt(40) + 10;
        addShapes(nShapes);
    }

    // constructor to add random Shape objects to the list
    public ShapeList() {
        // call the superclass constructor
        super();
        // add random Shape objects to the list (between 10 and 49)
        nShapes = random.nextInt(40) + 10;
        addShapes(nShapes);
        // if we try to instantiate an abstract class, we get an error
        // because abstract classes can only be extended, not instantiated
        // Shape theShape = new Shape();
    }

    // add getter for nShapes
    public int getNShapes() {
        return nShapes;
    }

    // add setter for nShapes
    public void setNShapes(int nShapes) {
        this.nShapes = nShapes;
    }

    // add getter for width
    public int getWidth() {
        return width;
    }

    // add setter for width
    public void setWidth(int width) {
        this.width = width;
    }

    // add getter for height
    public int getHeight() {
        return height;
    }   

    // add setter for height
    public void setHeight(int height) {
        this.height = height;
    }

    public void addShapes(int nShapes) {
        this.nShapes = nShapes;
        for (int i = 0; i < nShapes; i++) {
            // add a random Shape to the list
            this.add(getRandomShape());
        }

    }

    // method to return a random Shape
    public Shape getRandomShape() {
        // add a random shape
        // generate a random number between 0 and 4
        
        Shape shape = new Circle();;
        int shapeChoice = random.nextInt(5);
        switch (shapeChoice) {
            case 0:
                // circle needs a center x, center y, radius, and color
                shape = new Circle(
                        random.nextDouble() * width, random.nextDouble() * height,
                        random.nextDouble() * 100, getRandomColor());
                
            case 1:
                // generate a random Ellipse
                shape = new Ellipse(
                        random.nextDouble() * width, random.nextDouble() * height,
                        random.nextDouble() * 100, random.nextDouble() * 100);
                // set the fill color to a random color
                shape.setFill(getRandomColor());
                break;
                
            case 2:
                // generate a random Rectangle
                shape = new Rectangle(
                        random.nextDouble() * width, random.nextDouble() * height,
                        random.nextDouble() * 100, random.nextDouble() * 100);
                // set the fill color to a random color
                shape.setFill(getRandomColor());
                break;
                
            case 3:
                Line line = new Line(
                        random.nextDouble() * width, random.nextDouble() * height,
                        random.nextDouble() * width, random.nextDouble() * height);
                line.setStroke(getRandomColor());
                line.setStrokeWidth(random.nextInt(10) + 2);
                return line;
            case 4:
                // generate a random Polygon with 3 to 10 sides
                int nSides = random.nextInt(8) + 3;
                // create an array of doubles to hold the x and y coordinates of the vertices
                double[] vertices = new double[nSides * 2];
                // fill the array with random x and y coordinates
                for (int i = 0; i < nSides * 2; i++) {
                    vertices[i] = random.nextDouble() * width;
                }
                shape = new Polygon(vertices);
                shape.setFill(getRandomColor());
                break;
            default:
            shape = new Circle(
                random.nextDouble() * width, random.nextDouble() * height,
                random.nextDouble() * 100, getRandomColor());
        }

        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(3);
        shape.setStrokeType(StrokeType.OUTSIDE);
        return shape;


    }

    // add a toString() method to return a String representation of the list

    @Override
    public String toString() {
        // go through the list and print out something relevant to each kind of Shape
        StringBuilder s = new StringBuilder();

        // asking each kind of Shape to do something, and each Shape responds in a different
        // way depending on what kind of Shape it is, is an example of *polymorphism*
        // thing we're asking each Shape to do: print out something about itself
        for (Shape shape: this) {
            // instanceof is a keyword that checks to see if an object is an instance of a
            // specified class
            // using instanceof is an example of object reflection
            if (shape instanceof Circle) {
                // Tell Java that shape we're looking at right now is a Circle
                // using a *cast*: take shape and (Circle)shape tells Java
                // to treat it as a Circle
                Circle circle = (Circle)shape;
                s.append("Circle: center x = ");
                s.append(circle.getCenterX());
                s.append(", center y = ");
                s.append(circle.getCenterY());
                s.append(", radius = ");
                s.append(circle.getRadius());
                s.append(", color = ");
                s.append(circle.getFill());
                s.append("\n");
            } else if (shape instanceof Ellipse) {
                s.append("Ellipse: center x = ");
                s.append(((Ellipse) shape).getCenterX());
                s.append(", center y = ");
                s.append(((Ellipse) shape).getCenterY());
                s.append(", radius x = ");
                s.append(((Ellipse) shape).getRadiusX());
                s.append(", radius y = ");
                s.append(((Ellipse) shape).getRadiusY());
                s.append(", color = ");
                s.append(((Ellipse) shape).getFill());
                s.append("\n");
            } else if (shape instanceof Rectangle) {
                s.append("Rectangle: x = ");
                s.append(((Rectangle) shape).getX());
                s.append(", y = ");
                s.append(((Rectangle) shape).getY());
                s.append(", width = ");
                s.append(((Rectangle) shape).getWidth());
                s.append(", height = ");
                s.append(((Rectangle) shape).getHeight());
                s.append(", color = ");
                s.append(((Rectangle) shape).getFill());
                s.append("\n");
            } else if (shape instanceof Line) {
                s.append("Line: start x = ");
                s.append(((Line) shape).getStartX());
                s.append(", start y = ");
                s.append(((Line) shape).getStartY());
                s.append(", end x = ");
                s.append(((Line) shape).getEndX());
                s.append(", end y = ");
                s.append(((Line) shape).getEndY());
                s.append(", color = ");
                s.append(((Line) shape).getStroke());
                s.append("\n");
            } else if (shape instanceof Polygon) {
                s.append("Polygon: vertices = ");
                s.append(((Polygon) shape).getPoints());
                s.append(", color = ");
                s.append(((Polygon) shape).getFill());
                s.append("\n");
            }
        }
        return s.toString();
    }

}
