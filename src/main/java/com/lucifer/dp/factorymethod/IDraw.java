package com.lucifer.dp.factorymethod;

import com.lucifer.dp.decorator.BorderShape;
import com.lucifer.dp.decorator.Color;
import com.lucifer.dp.decorator.ColorShape;
import com.lucifer.dp.shape.Shape;

public interface IDraw {

    default void draw() {
        Shape s = makeShape();
        ColorShape cs = new ColorShape(s, Color.Blue);
        BorderShape bs = new BorderShape(cs, 1);
        bs.draw();
    }

    Shape makeShape();
}
