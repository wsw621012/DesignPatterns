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

    protected ExCircle(ExCircle c) {
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

    public static class InnerBuilder {
        private ExCircle c;

        private InnerBuilder(int radius) {
            c = new ExCircle(radius);
        }

        public static InnerBuilder init(int radius) {
            return  new InnerBuilder(radius);
        }

        public InnerBuilder withColor(Color color) {
            this.c.color = color;
            return this;
        }

        public InnerBuilder withBoldSize(int boldSize) {
            this.c.boldSize = boldSize;
            return this;
        }

        public ExCircle build() {
            return new ExCircle(this.c);
        }
    }
}
