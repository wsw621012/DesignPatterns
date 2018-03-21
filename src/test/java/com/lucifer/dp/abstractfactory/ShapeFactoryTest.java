package com.lucifer.dp.abstractfactory;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lucifer.dp.shape.*;


public class ShapeFactoryTest {

	@Test
	public void testCircularShape() {
		Shape s = ShapeAgent.create(CircularShapeFactory.class, Circle.class);
		assertTrue(s instanceof Circle);
		assertTrue(s instanceof CircularShape);
		assertTrue(s instanceof Shape);
		
		s = ShapeAgent.create(CircularShapeFactory.class, Ellipse.class);
		assertTrue(s instanceof Ellipse);
		assertTrue(s instanceof CircularShape);
		assertTrue(s instanceof Shape);
	}
	
	@Test
	public void testPolygonalShape() {
		Shape s = ShapeAgent.create(PolygonalShapeFactory.class, Square.class);
		assertTrue(s instanceof Square);
		assertTrue(s instanceof PolygonalShape);
		assertTrue(s instanceof Shape);
		
		s = ShapeAgent.create(PolygonalShapeFactory.class, Rectangle.class);
		assertTrue(s instanceof Rectangle);
		assertTrue(s instanceof PolygonalShape);
		assertTrue(s instanceof Shape);
		
		s = ShapeAgent.create(PolygonalShapeFactory.class, Triangle.class);
		assertTrue(s instanceof Triangle);
		assertTrue(s instanceof PolygonalShape);
		assertTrue(s instanceof Shape);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCircularShapeFactory_WrongShape() {
		ShapeAgent.create(CircularShapeFactory.class, Triangle.class);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPolygonalShapeFactory_WrongShape() {
		ShapeAgent.create(PolygonalShapeFactory.class, Ellipse.class);
	}
}
