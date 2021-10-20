package com.lucifer.dp.prototype;

import com.lucifer.dp.shape.Shape;

public class PosShape<T extends Shape> implements Prototype<PosShape>, Shape {

    int pos_x;
    int pos_y;

    Shape shape;
    Class clazz;

    public PosShape(int pos_x, int pos_y, Class<T> clazz) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.clazz = clazz;
        try {
            shape =  clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw() {
        shape.draw();
    }

    @Override
    public float area() {
        return shape.area();
    }

    @Override
    public PosShape clone() {
        return new PosShape(pos_x, pos_y, clazz);
    }
}
