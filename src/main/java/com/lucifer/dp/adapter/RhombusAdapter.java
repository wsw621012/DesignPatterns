package com.lucifer.dp.adapter;

import com.lucifer.dp.shape.Shape;

public class RhombusAdapter implements Shape {
    private Rhombus rhombus;

    public RhombusAdapter(Rhombus rhombus) {
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
        return new RhombusAdapter(new Rhombus(rhombus));
    }
}
