package com.lucifer.dp.bridge;

import com.lucifer.dp.decorator.Color;

public class OpenGLHandler implements DrawHandler {

	@Override
	public void drawLine(Point from, Point to) {
		System.out.println("Use OpenGL to draw line.");
	}

	@Override
	public void fillColor(Color color) {
		System.out.println("Use OpenGL to fill color.");
	}

}
