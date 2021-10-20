package com.lucifer.dp.abstractfactory.traditional;

import com.lucifer.dp.shape.Shape;

public interface TraditionalFactory {
    Shape createShape(String shapeName);
}
