package com.lucifer.dp.factory;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.factory.FactoryUseClone;
import com.lucifer.dp.shape.Circle;
import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.utils.JsonConverter;

public class FactoryUseCloneTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			Path path1 = Paths.get("json", "ShapeFactoryBaseClass.json");
			FactoryUseClone fc1 = JsonConverter.deserialize(path1, FactoryUseClone.class);
			
			Optional<Shape> circle1 = fc1.create("Circle");
			assertEquals(circle1.getClass().getName(), Circle.class.getName());
			
			Optional<Shape> circle2 = fc1.create("Circle");
			assertEquals(circle2.getClass().getName(), Circle.class.getName());
			
			assertNotEquals(circle1, circle2);
			
			assertEquals(circle1.get().area(), 0, 0.001);
			
			//fc = createShapeFactoryFromJson("json/ShapeFactoryClone.json");
			
			Path path2 = Paths.get("json", "ShapeFactoryClone.json");
			FactoryUseClone fc2 = JsonConverter.deserialize(path2, FactoryUseClone.class);
			
			Optional<Shape> circle3 = fc2.create("Circle");
			assertEquals(circle3.getClass().getName(), Circle.class.getName());
			
			assertEquals(circle3.get().area(), 314, 0.1);
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
