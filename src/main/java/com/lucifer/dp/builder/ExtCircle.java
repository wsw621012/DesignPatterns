package com.lucifer.dp.builder;

import com.lucifer.dp.decorator.Color;

public class ExtCircle {
    private int radius;
    private Color color;
    private int boldSize;

    public ExtCircle(int radius) {
        this.radius = radius;
        this.color = Color.Yellow;
        this.boldSize = 1;
    }

    private ExtCircle(Builder builder) {
        this.radius = builder.radius;
        this.color = builder.color;
        this.boldSize = builder.boldSize;
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

    public static class Builder {
        private int radius;
        private Color color;
        private int boldSize;

        public Builder withRadius(int radius) {
            this.radius = radius;
            return this;
        }

        public Builder withColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder withBoldSize(int boldSize) {
            this.boldSize = boldSize;
            return this;
        }

        public ExtCircle build() {
            return new ExtCircle(this);
        }
    }
}
