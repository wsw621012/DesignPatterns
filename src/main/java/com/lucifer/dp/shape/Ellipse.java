package com.lucifer.dp.shape;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ellipse implements CircularShape {

	private final int radius1;
	private final int radius2;
	
	@Override
	public void draw() {
		System.out.println("I'm an ellipse.");
	}

	@Override
	public Shape clone() {
		return new Ellipse(this);
	}

	@Override
	public float area() {
		return RATIO * radius1 * radius2;
	}
	
	public Ellipse() {
		radius1 = 0;
		radius2 = 0;
	}
	
	@JsonCreator
	public Ellipse(@JsonProperty("radius1") int ra, @JsonProperty("radius2") int rb) {
		this.radius1 = ra;
		this.radius2 = rb;
	}
	
	protected Ellipse(Ellipse ellipse) {
		this.radius1 = ellipse.radius1;
		this.radius2 = ellipse.radius2;
	}
}
