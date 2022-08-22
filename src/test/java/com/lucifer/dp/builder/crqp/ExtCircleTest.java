package com.lucifer.dp.builder.crqp;

import com.lucifer.dp.decorator.Color;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExtCircleTest {

    @Test
    public void testExtBuilder() {
        //ExtCircle circle = new ExtCircle.Builder().withRadius(5).build();

        ExtCircle extCircle = new ExtCircle.CrgpBuilder().withRadius(5).withColor(Color.Blue).withBoldSize(1).build();
        assertEquals(5, extCircle.getRadius());
        assertEquals(Color.Blue, extCircle.getColor());
        assertEquals(1, extCircle.getBoldSize());
    }

}