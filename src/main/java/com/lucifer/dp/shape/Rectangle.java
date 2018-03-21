package com.lucifer.dp.shape;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rectangle implements PolygonalShape {

	private int width;
	private int height;
	
	@Override
	public void draw() {
		System.out.println("I'm a rectangle.");
	}

	@Override
	public Shape clone() {
		return new Rectangle(this);
	}

	@Override
	public float area() {
		return width * height;
	}
	
	public Rectangle() {
		width = 0;
		height = 0;
	}
	
	@JsonCreator
	public Rectangle(@JsonProperty("width") int width, @JsonProperty("height") int height) {
		this.width = width;
		this.height = height;
	}
	
	protected Rectangle(Rectangle rectangle) {
		this.width = rectangle.width;
		this.height = rectangle.height;
	}

}
