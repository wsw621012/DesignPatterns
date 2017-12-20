package com.lucifer.dp.bridge;

import com.lucifer.dp.decorator.Color;

public class DirectXHandler implements DrawHandler {

	@Override
	public void drawLine(Point from, Point to) {
		System.out.println("Use DirectX to draw line.");
	}

	@Override
	public void fillColor(Color color) {
		System.out.println("Use DirectX to fill color.");
	}

}
