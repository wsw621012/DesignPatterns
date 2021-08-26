package com.lucifer.dp.builder;

import com.lucifer.dp.shape.Circle;

public class CircleBuilder {

    private Circle circle;

    public Circle build() {
        if (circle == null) {
            return new Circle();
        }
        Circle tmp = this.circle;
        this.circle = null;
        return tmp;
    }
}
