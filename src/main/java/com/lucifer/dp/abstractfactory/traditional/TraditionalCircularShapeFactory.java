package com.lucifer.dp.abstractfactory.traditional;

import com.lucifer.dp.shape.Circle;
import com.lucifer.dp.shape.Ellipse;
import com.lucifer.dp.shape.Shape;

public class TraditionalCircularShapeFactory implements TraditionalFactory {

    @Override
    public Shape createShape(String shapeName) {
        if (shapeName.equals("circle")) {
            return new Circle();
        } else if (shapeName.equals("ellipse")) {
            return new Ellipse();
        }
        return null;
    }
}
