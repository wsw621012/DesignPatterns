package com.lucifer.dp.interpreter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AndExpression implements Expression {

	private final Expression exp1;
	private final Expression exp2;
	
	@JsonCreator
	public AndExpression(@JsonProperty("exp1") Expression exp1, @JsonProperty("exp2") Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	@Override
	public boolean interpret(Context context) {
		return (exp1.interpret(context) && exp2.interpret(context));		
	}

	@Override
	public String print(Context context) {
		return String.format("( %s AND %s )", exp1.print(context), exp2.print(context));
	}
}
