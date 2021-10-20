package com.lucifer.dp.decorator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucifer.dp.shape.Shape;

public class ShapeDecorator implements Shape {

	//@JsonUnwrapped
	@JsonProperty()
	private Shape shape;
	
	@JsonCreator
	public ShapeDecorator(@JsonProperty("shape") Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public void draw() {
		shape.draw();
	}
	
	@Override
	public float area() {
		return shape.area();
	}
	
	@Override
	public Shape clone() {
		return shape.clone();
	}
}
