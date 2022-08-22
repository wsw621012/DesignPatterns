package com.lucifer.dp.builder;

import com.lucifer.dp.decorator.Color;


public class NoGoodExCircleBuilder {

    private ExtCircle circle;

    public NoGoodExCircleBuilder create(int radius) {
        circle = new ExtCircle(radius);
        return this;
    }

    public NoGoodExCircleBuilder withColor(Color color) {
        circle.setColor(color);
        return this;
    }

    public NoGoodExCircleBuilder withBoldSize(int boldSize) {
        circle.setBoldSize(boldSize);
        return this;
    }

    public ExtCircle build() {
        return circle;
    }
}
