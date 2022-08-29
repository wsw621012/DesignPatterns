package com.lucifer.dp.adapter;

public class Rhombus {

    private final int width;
    private final double acuteAngle;

    public Rhombus() {
        width = 1;
        acuteAngle = Math.PI / 4.0;
    }

    public Rhombus(Rhombus rhombus) {
        this.width = rhombus.width;
        this.acuteAngle = rhombus.acuteAngle;
    }

    public int getWidth() {
        return width;
    }

    public double getAcuteAngle() {
        return acuteAngle;
    }

    public void draw() {
        System.out.println("I'm a star.");
    }

}
