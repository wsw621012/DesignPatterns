package com.lucifer.dp.factory;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucifer.dp.shape.Shape;

public class FactoryUseClone {

	@JsonProperty("shapes")
	private Map<String, Shape> shapes;
	
	protected void setShapes(Map<String, Shape> shapes) {
		this.shapes = shapes;
	}
	
	public Shape create(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (shapes.containsKey(name)) {
			return shapes.get(name).clone();
		}
		return null;
	}
}
