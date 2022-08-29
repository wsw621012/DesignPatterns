package com.lucifer.dp.factory;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.factory.FactoryUseBaseClass;
import com.lucifer.dp.shape.Circle;
import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.utils.JsonConverter;

public class FactoryUseBaseClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			Path path = Paths.get("json", "ShapeFactoryBaseClass.json");
			FactoryUseBaseClass fbc = JsonConverter.deserialize(path, FactoryUseBaseClass.class);
			
			Shape circle1 = fbc.create("Circle").get();
			assertEquals(circle1.getClass().getName(), Circle.class.getName());
			
			Shape circle2 = fbc.create("Circle").get();
			assertEquals(circle2.getClass().getName(), Circle.class.getName());
			
			assertEquals(circle1, circle2);
			
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
