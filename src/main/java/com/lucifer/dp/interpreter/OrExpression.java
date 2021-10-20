package com.lucifer.dp.interpreter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrExpression implements Expression {

	private Expression exp1;
	
	private Expression exp2;
	
	@JsonCreator
	public OrExpression(@JsonProperty("exp1") Expression exp1, @JsonProperty("exp2") Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	@Override
	public boolean interpret(Context context) {
		return (exp1.interpret(context) || exp2.interpret(context));
	}

	@Override
	public String print(Context context) {
		return String.format("( %s OR %s )", exp1.print(context), exp2.print(context));
	}
}
