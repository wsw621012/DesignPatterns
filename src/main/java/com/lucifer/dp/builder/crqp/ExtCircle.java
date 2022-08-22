package com.lucifer.dp.builder.crqp;

import com.lucifer.dp.decorator.Color;

public class ExtCircle extends BaseCircle {

    private Color color;
    private int boldSize;

    public ExtCircle(int radius, Color color, int boldSize) {
        super(radius);
        this.color = color;
        this.boldSize = boldSize;
    }

    protected ExtCircle(Builder builder) {
        super(builder);
        this.color = builder.color;
        this.boldSize = builder.boldSize;
    }

    public Color getColor() {
        return color;
    }

    public int getBoldSize() {
        return boldSize;
    }

    public static class Builder extends BaseCircle.Builder {
        private Color color;
        private int boldSize;

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

    private ExtCircle(CrgpBuilder builder) {
        super(builder.getRadius());
        this.color = builder.color;
        this.boldSize = builder.boldSize;
    }

    public static class CrgpBuilder extends BaseCircle.CrgpBuilder<CrgpBuilder> {

        private Color color;
        private int boldSize;

        public CrgpBuilder withColor(Color color) {
            this.color = color;
            return this;
        }

        public CrgpBuilder withBoldSize(int boldSize) {
            this.boldSize = boldSize;
            return this;
        }

        public ExtCircle build() {
            return new ExtCircle(this);
        }
    }
}
