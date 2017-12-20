package com.lucifer.dp.shape;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Circle extends Ellipse {

	@Override
	public void draw() {
		System.out.println("I'm a circle.");
	}
	
	@Override
	public Shape clone() {
		return new Circle(this);
	}

	public Circle() {
		super();
	}

	@JsonCreator
	public Circle(@JsonProperty("radius") int radius) {
		super(radius, radius);
	}
	
	protected Circle(Circle circle) {
		super(circle);
	}
}
