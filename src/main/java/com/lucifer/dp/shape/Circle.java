package com.lucifer.dp.shape;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Circle implements CircularShape {

	private int radius;
	
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
		this.radius = radius;
	}
	
	protected Circle(Circle circle) {
		this.radius = circle.radius;
	}

	@Override
	public float area() {
		return RATIO * radius * radius;
	}
}
