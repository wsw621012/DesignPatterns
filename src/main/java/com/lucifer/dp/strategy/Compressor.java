package com.lucifer.dp.strategy;

import java.io.InputStream;
import java.io.OutputStream;

public class Compressor {

	private CompressStrategy strategy;
	
	public Compressor(CompressStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void compress(InputStream in, OutputStream out) {
		strategy.compress(in, out);
	}
}
