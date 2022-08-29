package com.lucifer.dp.bridge;

import com.lucifer.dp.decorator.Color;

public interface DrawHandler {

	void drawLine(Point from, Point to);
	
	void fillColor(Color color);
}
