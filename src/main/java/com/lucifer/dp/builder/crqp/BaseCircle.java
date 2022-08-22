package com.lucifer.dp.builder.crqp;

public class BaseCircle {
    private int radius;

    public BaseCircle(int radius) {
        this.radius = radius;
    }

    protected BaseCircle(Builder builder) {
        this.radius = builder.radius;
    }

    public int getRadius() {
        return radius;
    }

    public static class Builder {
        private int radius;

        public Builder withRadius(int radius) {
            this.radius = radius;
            return this;
        }

        public BaseCircle build() {
            return new BaseCircle(this);
        }
    }

    private BaseCircle(CrgpBuilder builder) {
        this.radius = builder.radius;
    }

    public static class CrgpBuilder<T extends CrgpBuilder<T>> {
        private int radius;

        public int getRadius() {
            return radius;
        }

        public T withRadius(int radius) {
            this.radius = radius;
            return (T)this;
        }

        public BaseCircle build() {
            return new BaseCircle(this);
        }
    }
}
