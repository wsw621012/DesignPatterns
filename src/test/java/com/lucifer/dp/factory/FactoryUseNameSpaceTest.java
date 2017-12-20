package com.lucifer.dp.factory;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.factory.FactoryUseNameSpace;
import com.lucifer.dp.shape.Circle;
import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.utils.JsonConverter;

public class FactoryUseNameSpaceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			Path path = Paths.get("json", "ShapeFactoryNameSpace.json");
			FactoryUseNameSpace fns = JsonConverter.deserialize(path, FactoryUseNameSpace.class);
			Shape circle = fns.create("Circle");
			assertEquals(circle.getClass().getName(), Circle.class.getName());
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
