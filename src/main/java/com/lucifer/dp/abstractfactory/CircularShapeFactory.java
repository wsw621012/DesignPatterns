package com.lucifer.dp.abstractfactory;

import com.lucifer.dp.exception.InitFailException;
import com.lucifer.dp.shape.CircularShape;
import com.lucifer.dp.shape.Shape;


public class CircularShapeFactory implements ShapeFactory {

	@Override
	public <T extends Shape> Shape create(Class<T> clazz) {
		if (!CircularShape.class.isAssignableFrom(clazz)) {
			throw new IllegalArgumentException("no such kind of circular shape.");
		}
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InitFailException(e);
		}
	}

}
