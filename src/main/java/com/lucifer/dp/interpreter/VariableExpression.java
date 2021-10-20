package com.lucifer.dp.interpreter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VariableExpression implements Expression {

	
	private final String name;

	@JsonCreator
	public VariableExpression(@JsonProperty("name") String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	@Override
	public boolean interpret(Context context) {
		return context.lookup(name);
	}
	
	@Override
	public String print(Context context) {
		return String.format("%s:%s", name, context.lookup(name));
	}

}
