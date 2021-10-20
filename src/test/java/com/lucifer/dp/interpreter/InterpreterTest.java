package com.lucifer.dp.interpreter;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.Test;

import com.lucifer.dp.interpreter.AndExpression;
import com.lucifer.dp.interpreter.Constant;
import com.lucifer.dp.interpreter.Context;
import com.lucifer.dp.interpreter.Expression;
import com.lucifer.dp.interpreter.NotExpression;
import com.lucifer.dp.interpreter.OrExpression;
import com.lucifer.dp.interpreter.VariableExpression;
import com.lucifer.dp.utils.JsonConverter;

public class InterpreterTest {

	@Test
	public void test() {
		/* (true and x) or (y and (not x)) */
		
		Context ctx = new Context();
		VariableExpression x = new VariableExpression("x");
		VariableExpression y = new VariableExpression("y");
		
		Expression exp = new OrExpression(
				new AndExpression(new Constant(true), x),
				new AndExpression(y, new NotExpression(x)));
		
		ctx.assign(x, false);
		ctx.assign(y, true);
		
		assertTrue(exp.interpret(ctx));
		
		//System.out.println(JsonConverter.serialize(exp));
	}
	
	@Test
	public void test1() {
		Expression exp = JsonConverter.deserialize(Paths.get("json", "Interpreter.json"), Expression.class);
		
		Context ctx = new Context();
		
		ctx.assign(new VariableExpression("x"), false);
		ctx.assign(new VariableExpression("y"), true);
		
		assertTrue(exp.interpret(ctx));
		
		System.out.println(String.format("%s == %s", exp.print(ctx), exp.interpret(ctx)));
	}

}
