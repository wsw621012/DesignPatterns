package com.lucifer.dp.factorymethod;

import com.lucifer.dp.shape.Circle;
import com.lucifer.dp.shape.Shape;

public class CircleBrush implements IDraw {
    public Shape makeShape() {
        return new Circle();
    }
}
