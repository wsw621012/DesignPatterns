package com.lucifer.dp.singleton;

import java.nio.file.Paths;

import com.lucifer.dp.factory.FactoryUseNameSpace;
import com.lucifer.dp.utils.JsonConverter;

/** Thread-Safe **/
public class StaticBlockSingleton {

	private StaticBlockSingleton() {
	}

	private static final FactoryUseNameSpace instance;

	// static block initialization for exception handling
	static {
		try {
			instance = JsonConverter.deserialize(Paths.get("json", "ShapeFactoryNameSpace.json"),
					FactoryUseNameSpace.class);
		} catch (Exception e) {
			//do something for error handling.
		}
	}

	public static FactoryUseNameSpace getInstance() {
		return instance;
	}
}
