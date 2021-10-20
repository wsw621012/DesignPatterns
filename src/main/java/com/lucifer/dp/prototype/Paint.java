package com.lucifer.dp.prototype;

import com.lucifer.dp.shape.*;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Paint implements Prototype<Paint> {

    int pos_x, pos_y;

    private List<PosShape> shapes;

    public Paint(int pos_x, int pos_y) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        shapes = new ArrayList<>();
    }

    public void add(PosShape s) {
        shapes.add(s);
    }

    protected List<PosShape> getShapes() {
        return shapes;
    }

    @Override
    public Paint clone() {
        Paint p = new Paint(pos_x, pos_y);
        p.shapes = new ArrayList<>();
        for (PosShape s : this.shapes) {
            p.shapes.add(s.clone());
        }
        return p;
    }
}
