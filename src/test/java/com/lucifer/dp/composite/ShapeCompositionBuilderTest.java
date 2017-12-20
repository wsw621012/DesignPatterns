package com.lucifer.dp.composite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.composite.ShapeComposite;
import com.lucifer.dp.composite.ShapeCompositionBuilder;
import com.lucifer.dp.shape.*;

public class ShapeCompositionBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testSimpleBuilder() {
		ShapeCompositionBuilder builder = new ShapeCompositionBuilder();
		
		builder.with(new Circle(5));
		builder.with(new Circle(5));
		builder.with(new Rectangle(25, 20));
		builder.with(new Triangle(5, 5));
		builder.with(new Ellipse(15, 10));
		
		ShapeComposite comp = builder.build();
		assertEquals(comp.area(), 1140.5, 0.1);
		
	}
	
	@Test
	public void testCompositeBuilder() {
		ShapeComposite head = 
				new ShapeCompositionBuilder()
				.with(new Circle(5))
				.with(new Circle(5))
				.with(new Rectangle(25, 20))
				.with(new Triangle(5, 5))
				.with(new Ellipse(15, 10))
				.build();
		
		ShapeComposite lhand = 
				new ShapeCompositionBuilder()
				.with(new Rectangle(10, 20))
				.with(new Triangle(10, 5))
				.build();
		
		Shape rhand = lhand.clone();

		Shape body = new Rectangle(40, 80);
		
		ShapeComposite lfoot = 
				new ShapeCompositionBuilder()
				.with(new Rectangle(20, 30))
				.with(new Ellipse(10, 5))
				.build();
		
		Shape rfoot = lfoot.clone();
		
		ShapeComposite robot = 
				new ShapeCompositionBuilder()
				.with(head).with(body).with(lhand).with(rhand).with(lfoot).with(rfoot).build();
		
		assertEquals(robot.area(), 6304.5, 0.1);
		
	}
}
