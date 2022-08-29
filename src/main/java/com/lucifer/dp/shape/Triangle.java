package com.lucifer.dp.shape;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Triangle implements PolygonalShape {

	private final int base;
	private final int height;
	
	@Override
	public void draw() {
		System.out.println("I'm a triangle.");
	}

	@Override
	public Shape clone() {
		return new Triangle(this);
	}

	@Override
	public float area() {
		return base * height * 0.5f;
	}
	
	public Triangle() {
		base = 0;
		height = 0;
	}
	
	@JsonCreator
	public Triangle(@JsonProperty("base") int base, @JsonProperty("height") int height) {
		this.base = base;
		this.height = height;
	}
	
	
	private Triangle(Triangle triangle) {
		this.base = triangle.base;
		this.height = triangle.height;
	}
}
