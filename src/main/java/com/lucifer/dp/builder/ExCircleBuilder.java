package com.lucifer.dp.builder;

import com.lucifer.dp.decorator.Color;
import com.lucifer.dp.shape.Circle;


public class ExCircleBuilder {

    private ExCircle circle;

    public ExCircleBuilder create(int radius) {
        circle = new ExCircle(radius);
        return this;
    }

    public ExCircleBuilder withColor(Color color) {
        circle.setColor(color);
        return this;
    }

    public ExCircleBuilder withBoldSize(int boldSize) {
        circle.setBoldSize(boldSize);
        return this;
    }

    public ExCircle build() {
        return circle;
    }
}
