package com.lucifer.dp.strategy;

import java.io.InputStream;
import java.io.OutputStream;

import com.lucifer.dp.exception.InitFailException;

public enum CompressAlgorithm implements CompressStrategy {

	ZIP(Zip.class),
	GZ(Gzip.class),
	RAR(Rar.class);

	private final CompressStrategy algo;
	
	CompressAlgorithm(Class<?> type) {
		try {
			this.algo = (CompressStrategy) type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InitFailException(e);
		}
	}
	
	@Override
	public void compress(InputStream in, OutputStream out) {
		algo.compress(in, out);
	}
	
}
