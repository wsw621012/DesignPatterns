package com.lucifer.dp.decorator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucifer.dp.shape.Shape;

public class ColorShape extends ShapeDecorator {

	private final Color color;

	@JsonCreator
	public ColorShape(@JsonProperty("shape") Shape shape, @JsonProperty("color") Color color) {
		super(shape);
		this.color = color;
	}

	@Override
	public void draw() {
		super.draw();
		fillWithColor();
	}
	
	private void fillWithColor() {
		System.out.println(String.format("filled with color - %s.", color.toString()));
	}

}
