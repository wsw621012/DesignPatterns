package com.lucifer.dp.builder;

import static org.junit.Assert.*;

import com.lucifer.dp.decorator.Color;
import org.junit.Test;


public class ExCircleBuildTest {

    @Test
    public void testDefaultExCircleBuilderTest() {
        int radius = 3;
        Color defaultColor = Color.Yellow;
        int defaultBoldSize = 1;
        ExCircle defaultCircle = new ExCircleBuilder().create(radius).build();
        assertEquals(defaultCircle.getRadius(), radius);
        assertEquals(defaultCircle.getBoldSize(), defaultBoldSize);
        assertEquals(defaultCircle.getColor(), defaultColor);
    }

    @Test
    public void testWithValueExcircleBuildTest() {
        int radius = 5;
        Color customColor = Color.Red;
        int customBoldSize = 2;
        ExCircle customCircle = new ExCircleBuilder().create(radius).withColor(customColor).withBoldSize(customBoldSize).build();
        assertEquals(customCircle.getRadius(), radius);
        assertEquals(customCircle.getBoldSize(), customBoldSize);
        assertEquals(customCircle.getColor(), customColor);

        assertTrue(customCircle instanceof ExCircle);
    }

    @Test
    public void testInnerExtCircleBuilder() {
        int radius = 3;
        Color defaultColor = Color.Yellow;
        int defaultBoldSize = 1;
        ExCircle defaultCircle = ExCircle.Builder.init(radius).withColor(defaultColor).withBoldSize(defaultBoldSize).build();
        assertEquals(defaultCircle.getRadius(), radius);
        assertEquals(defaultCircle.getBoldSize(), defaultBoldSize);
        assertEquals(defaultCircle.getColor(), defaultColor);
    }
}
