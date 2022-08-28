package com.lucifer.dp.factory;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucifer.dp.shape.Shape;

public class FactoryUseClone {

	@JsonProperty("shapes")
	private Map<String, Shape> shapes;
	
	protected void setShapes(Map<String, Shape> shapes) {
		this.shapes = shapes;
	}
	
	public Optional<Shape> create(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (shapes.containsKey(name)) {
			return Optional.of(shapes.get(name).clone());
		}
		return Optional.empty();
	}
}
