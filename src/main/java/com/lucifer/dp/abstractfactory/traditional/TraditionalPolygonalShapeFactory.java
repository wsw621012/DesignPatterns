package com.lucifer.dp.abstractfactory.traditional;

import com.lucifer.dp.shape.Rectangle;
import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.shape.Square;
import com.lucifer.dp.shape.Triangle;

public class TraditionalPolygonalShapeFactory implements TraditionalFactory {

    @Override
    public Shape createShape(String shapeName) {
        if (shapeName.equals("rectangle")) {
            return new Rectangle();
        } else if (shapeName.equals("square")) {
            return new Square();
        } else if (shapeName.equals("triangle")) {
            return new Triangle();
        }
        return null;
    }
}
