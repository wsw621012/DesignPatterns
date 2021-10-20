package com.lucifer.dp.prototype;

import com.lucifer.dp.shape.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PaintTest {

    @Before
    public void setUp() throws Exception {
    }

//    void TestGeneric() {
//        PosShape<Circle> pc = new PosShape<Circle>(0, 0, Ellipse.class);
//    }

    @Test
    public void TestPaint() {

        List<PosShape> shapes = new ArrayList<PosShape>();

        shapes.add(new PosShape<Circle>(1, 9, Circle.class));
        shapes.add(new PosShape<Triangle>(2, 8, Triangle.class));
        shapes.add(new PosShape<Ellipse>(3, 7, Ellipse.class));
        shapes.add(new PosShape<Square>(4, 6, Square.class));
        shapes.add(new PosShape<Rectangle>(5, 5, Rectangle.class));

        Paint paint = new Paint(0,0);
        for (PosShape s : shapes) {
            paint.add(s);
        }

        List<PosShape> ps_old = paint.getShapes();
        assertEquals(ps_old.size(), shapes.size());
        for (int i = 0; i < shapes.size(); i++) {
            assertEquals(ps_old.get(i).pos_x,  shapes.get(i).pos_x);
            assertEquals(ps_old.get(i).pos_y,  shapes.get(i).pos_y);
            assertEquals(ps_old.get(i).getClass().getName(), shapes.get(i).getClass().getName());
        }


        Paint replica = paint.clone();

        assertEquals(paint.pos_x, replica.pos_x);
        assertEquals(paint.pos_y, replica.pos_y);

        List<PosShape> ps_new = replica.getShapes();

        assertEquals(paint.getShapes().size(), replica.getShapes().size());
        assertEquals(ps_old.size(), ps_new.size());
        for (int i = 0; i < ps_new.size(); i++) {
            assertNotEquals(ps_old.get(i), ps_new.get(i));
            assertEquals(ps_old.get(i).pos_x, ps_new.get(i).pos_x);
            assertEquals(ps_old.get(i).pos_y, ps_new.get(i).pos_y);
            assertEquals(ps_old.get(i).getClass().getName(), ps_new.get(i).getClass().getName());
        }

    }
}