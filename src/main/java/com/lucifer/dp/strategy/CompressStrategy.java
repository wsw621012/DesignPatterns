package com.lucifer.dp.strategy;

import java.io.InputStream;
import java.io.OutputStream;

public interface CompressStrategy {

	void compress(InputStream in, OutputStream out);
}
