package com.lucifer.dp.strategy;

import java.io.InputStream;
import java.io.OutputStream;

import com.lucifer.dp.exception.InitFailException;

public class GenericCompresser<T extends CompressStrategy> {

	private CompressStrategy strategy;
	private Class<T> type;
	
	public GenericCompresser() {
		try {
			strategy = type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InitFailException(e);
		} 
	}
	
	public void compress(InputStream in, OutputStream out) {
		strategy.compress(in, out);
	}
}
