package com.lucifer.dp.shape;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Square implements PolygonalShape {

	private int length;
	
	@Override
	public void draw() {
		System.out.println("I'm a square.");
	}

	@Override
	public Shape clone() {
		return new Square(this);
	}

	public Square() {
		super();
	}
	
	@JsonCreator
	public Square(@JsonProperty("length") int length) {
		this.length = length;
	}
	
	protected Square(Square square) {
		this.length = square.length;
	}

	@Override
	public float area() {
		return length * length;
	}
	
	
}
