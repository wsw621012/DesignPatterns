package com.lucifer.dp.decorator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucifer.dp.shape.Shape;

public class BorderShape extends ShapeDecorator {

	private final int width;
	
	@JsonCreator
	public BorderShape(@JsonProperty("shape") Shape shape, @JsonProperty("width") int width) {
		super(shape);
		this.width = width;
	}

	@Override
	public void draw() {
		super.draw();
		drawBorder();
	}
	
	private void drawBorder() {
		System.out.println(String.format("draw with %d(pix) border.", width));
	}
}
