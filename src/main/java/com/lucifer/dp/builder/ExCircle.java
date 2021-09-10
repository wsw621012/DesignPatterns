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

    private ExCircle(ExCircle c) {
        this.radius = c.radius;
        this.color = c.color;
        this.boldSize = c.boldSize;
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
        private ExCircle c;

        private Builder(int radius) {
            c = new ExCircle(radius);
        }

        public static Builder init(int radius) {
            return new Builder(radius);
        }

        public Builder withColor(Color color) {
            this.c.color = color;
            return this;
        }

        public Builder withBoldSize(int boldSize) {
            this.c.boldSize = boldSize;
            return this;
        }

        public ExCircle build() {
            return new ExCircle(this.c);
        }
    }
}
