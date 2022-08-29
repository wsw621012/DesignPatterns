package com.lucifer.dp.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucifer.dp.shape.Shape;

public class ShapeComposite implements Shape {

	@JsonProperty("shapes")
	private final List<Shape> shapes;
	
	public void add(Shape shape) {
		shapes.add(shape);
	}
	
	@Override
	public void draw() {
		shapes.forEach(s -> s.draw());
	}

	@Override
	public float area() {
		return (float) shapes.stream().mapToDouble(s -> s.area()).sum();		
	}

	@Override
	public Shape clone() {
		return new ShapeComposite(shapes.stream().map(s -> s.clone()).collect(Collectors.toList()));
	}

	public ShapeComposite(List<Shape> shapes) {
		this.shapes = shapes;
	}
	
	public ShapeComposite() {
		shapes = new ArrayList<Shape>();
	}
}
