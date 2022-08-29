package com.lucifer.dp.shape;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lucifer.dp.composite.ShapeComposite;
import com.lucifer.dp.decorator.BorderShape;
import com.lucifer.dp.decorator.ColorShape;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Circle.class, name = "Circle"),
	@JsonSubTypes.Type(value = Ellipse.class, name = "Ellipse"),
	@JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle"),
	@JsonSubTypes.Type(value = Triangle.class, name = "Triangle"),
	@JsonSubTypes.Type(value = Square.class, name = "Square"),
	@JsonSubTypes.Type(value = ShapeComposite.class, name = "Composite"),
	@JsonSubTypes.Type(value = ColorShape.class, name = "Color"),
	@JsonSubTypes.Type(value = BorderShape.class, name = "Border")
})
public interface Shape {

	void draw();
	
	float area();
	
	Shape clone();
}
