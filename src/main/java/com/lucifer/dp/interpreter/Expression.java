package com.lucifer.dp.interpreter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = AndExpression.class, name = "AND"),
	@JsonSubTypes.Type(value = OrExpression.class, name = "OR"),
	@JsonSubTypes.Type(value = NotExpression.class, name = "NOT"),
	@JsonSubTypes.Type(value = Constant.class, name = "CONST"),
	@JsonSubTypes.Type(value = VariableExpression.class, name = "VAR"),
})
	
public interface Expression {

	public boolean interpret(Context context);
	
	public String print(Context context);
}
