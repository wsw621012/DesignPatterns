package com.lucifer.dp.interpreter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotExpression implements Expression {

	private Expression exp;
	
	@JsonCreator
	public NotExpression(@JsonProperty("exp") Expression exp) {
		this.exp = exp;
	}
	
	@Override
	public boolean interpret(Context context) {
		return !exp.interpret(context);
	}

	@Override
	public String print(Context context) {
		return String.format("( NOT %s )", exp.print(context));
	}
}
