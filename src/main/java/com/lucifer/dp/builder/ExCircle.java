package com.lucifer.dp.builder;

import com.lucifer.dp.decorator.Color;

public class ExCircle {
    private int radius;
    private Color color;
    private int boldSize;

    public ExCircle(int radius) {
        this.radius = radius;
        this.color = Color.Yellow;
        this.boldSize = 1;
    }

    public int getRadius() {
        return radius;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setBoldSize(int boldSize) {
        this.boldSize = boldSize;
    }

    public int getBoldSize() {
        return boldSize;
    }
}
