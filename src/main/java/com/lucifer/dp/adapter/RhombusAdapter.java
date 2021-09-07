package com.lucifer.dp.adapter;

import com.lucifer.dp.shape.Shape;

public class ShapeAdapterWithRhombus implements Shape {
    private Rhombus rhombus;

    public ShapeAdapterWithRhombus(Rhombus rhombus) {
        this.rhombus = new Rhombus(rhombus);
    }

    @Override
    public void draw() {
        rhombus.draw();
    }

    @Override
    public float area() {
        return (float) (rhombus.getWidth() * rhombus.getWidth() * Math.cos(rhombus.getAcuteAngle()));
    }

    @Override
    public Shape clone() {
        ShapeAdapterWithRhombus shape = new
        return new Rhombus(rhombus.getWidth(), rhombus.getAcuteAngle());
    }
}
