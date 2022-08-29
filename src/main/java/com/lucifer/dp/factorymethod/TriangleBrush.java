package com.lucifer.dp.factorymethod;

import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.shape.Triangle;

public class TriangleBrush implements IDraw {
    public Shape makeShape() {
        return new Triangle();
    }
}
