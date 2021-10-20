package com.lucifer.dp.decorator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.lucifer.dp.decorator.BorderShape;
import com.lucifer.dp.decorator.Color;
import com.lucifer.dp.decorator.ColorShape;
import com.lucifer.dp.shape.Circle;
import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.utils.JsonConverter;

public class ShapeDecoratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Shape s = new ColorShape(new BorderShape(new Circle(), 5), Color.Red);
		s.draw();
		System.out.println(JsonConverter.serialize(s));
	}

	@Test
	public void test1() {
		Shape s = JsonConverter.deserialize(Paths.get("json", "DecorateRobot.json"), Shape.class);
		s.draw();
	}

}
