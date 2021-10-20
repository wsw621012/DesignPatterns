package com.lucifer.dp.abstractfactory;

import java.util.HashMap;
import java.util.Map;

import com.lucifer.dp.exception.InitFailException;
import com.lucifer.dp.shape.Shape;

///< no thread-safe
public class ShapeAgent {

	private final static ShapeAgent instance = new ShapeAgent();

	private final Map<Class<?>, ShapeFactory> factories;

	public static <T extends ShapeFactory, U extends Shape> Shape create(Class<T> clazz, Class<U> shape) {
		return instance.get(clazz).create(shape);
	}

	private ShapeAgent() {
		 factories = new HashMap<>();
	}

	private <T extends ShapeFactory> ShapeFactory get(Class<T> clazz) {
		if (!factories.containsKey(clazz)) {
			try {
				factories.put(clazz, clazz.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				throw new InitFailException(e);
			}
		}
		return factories.get(clazz);

	}
}
