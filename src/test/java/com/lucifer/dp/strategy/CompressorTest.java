package com.lucifer.dp.strategy;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class CompressorTest {

	private final String origin = "THIS IS A TEST";

	@Test
	public void testAlgo() {
		for (CompressAlgorithm algo : CompressAlgorithm.values()) {
			Compressor c = new Compressor(algo);
			try (InputStream in = new ByteArrayInputStream(origin.getBytes());
					ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				c.compress(in, out);
				String afterZip = out.toString();

				assertEquals(algo.toString() + origin, afterZip);

			} catch (IOException e) {
				e.printStackTrace();
				fail();
			}
		}

	}

}
