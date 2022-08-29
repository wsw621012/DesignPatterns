package com.lucifer.dp.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Context {

	private final Map<String, Boolean> table = new HashMap<>();
	
	public void assign(VariableExpression exp, Boolean v) {
		table.put(exp.getName(), v);
	}
	
	public final Boolean lookup(String name) {
		return table.get(name);
	}
}
