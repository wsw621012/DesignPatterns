package com.lucifer.dp.interpreter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Constant implements Expression {

	private final boolean bool;
	
	@JsonCreator
	public Constant(@JsonProperty("bool") boolean bool) {
		this.bool = bool;
	}
	
	@Override
	public boolean interpret(Context context) {
		return bool;
	}

	@Override
	public String print(Context context) {
		return String.format("%s", bool);
	}
}
