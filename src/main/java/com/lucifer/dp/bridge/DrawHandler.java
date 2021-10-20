package com.lucifer.dp.bridge;

import com.lucifer.dp.decorator.Color;

public interface DrawHandler {

	public void drawLine(Point from, Point to);
	
	public void fillColor(Color color);
}
