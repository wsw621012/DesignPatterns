package com.lucifer.dp.abstractfactory;

import com.lucifer.dp.exception.InitFailException;
import com.lucifer.dp.shape.CircularShape;
import com.lucifer.dp.shape.PolygonalShape;
import com.lucifer.dp.shape.Rectangle;
import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.shape.Square;
import com.lucifer.dp.shape.Triangle;

public class PolygonalShapeFactory implements ShapeFactory {

	@Override
	public <T extends Shape> Shape create(Class<T> clazz) {
		if (!PolygonalShape.class.isAssignableFrom(clazz)) {
			throw new IllegalArgumentException("no such kind of circular shape.");
		}
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InitFailException(e);
		}
	}

}
