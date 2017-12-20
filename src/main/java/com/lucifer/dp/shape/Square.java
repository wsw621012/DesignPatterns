package com.lucifer.dp.shape;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Square extends Rectangle {

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
		super(length, length);
	}
	
	protected Square(Square square) {
		super(square);
	}
}
