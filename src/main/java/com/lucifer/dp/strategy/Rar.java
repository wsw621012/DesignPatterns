package com.lucifer.dp.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Rar implements CompressStrategy {

	@Override
	public void compress(InputStream in, OutputStream out) {
		String protocal = "RAR";
		try {
			out.write(protocal.getBytes());
			byte[] buffer = new byte[8 * 1024];
		    int bytesRead;
		    while ((bytesRead = in.read(buffer)) != -1) {
		        out.write(buffer, 0, bytesRead);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
