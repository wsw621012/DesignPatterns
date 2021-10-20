package com.lucifer.dp.abstractfactory;

import com.lucifer.dp.shape.Shape;

public interface ShapeFactory {

	public <T extends Shape> Shape create(Class<T> clazz);
}
