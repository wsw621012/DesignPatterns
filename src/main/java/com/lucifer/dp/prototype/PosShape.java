package com.lucifer.dp.prototype;

import com.lucifer.dp.shape.Circle;

public class PositionCircle implements Prototype<PositionCircle> extends Circle {

    int pox_x;
    int pos_y;
    

    @Override
    public PositionCircle clone() {
        return new PositionCircle();
    }
}
