package com.lucifer.dp.composite;

import java.util.ArrayList;
import java.util.List;

import com.lucifer.dp.shape.Shape;


public class ShapeCompositionBuilder {

	private List<Shape> shapes;
	
	public ShapeCompositionBuilder() {
		this.shapes = new ArrayList<Shape>();
	}
	
	public ShapeCompositionBuilder with(Shape shape) {
		shapes.add(shape);
		return this;
	}
	
	public ShapeComposite build() {
		return new ShapeComposite(shapes);
	}
}
