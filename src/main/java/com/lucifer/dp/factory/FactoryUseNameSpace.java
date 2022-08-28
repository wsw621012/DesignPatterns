package com.lucifer.dp.factory;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucifer.dp.shape.Shape;

public class FactoryUseNameSpace {

	@JsonProperty("shapes")
	private Map<String, String> shapes;
	
	protected void setShapes(Map<String, String> shapes) {
		this.shapes = shapes;
	}

	public Optional<Shape> create(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (shapes.containsKey(name)) {
			return Optional.of((Shape)Class.forName(shapes.get(name)).newInstance());
		}
		return Optional.empty();
	}
}
