package com.lucifer.dp.composite;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.utils.JsonConverter;

public class ShapeCompositionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {

		Path path = Paths.get("json", "ShapeComposition.json");
		Shape head = JsonConverter.deserialize(path, Shape.class);
		assertEquals(head.area(), 1140.5, 0.1);

	}

	@Test
	public void test2() {

		Path path = Paths.get("json", "Robot.json");
		Shape robot = JsonConverter.deserialize(path, Shape.class);
		assertEquals(robot.area(), 6304.5, 0.1);

	}
}
