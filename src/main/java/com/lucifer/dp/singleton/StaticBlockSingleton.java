package com.lucifer.dp.singleton;

import java.nio.file.Paths;

import com.lucifer.dp.factory.FactoryUseNameSpace;
import com.lucifer.dp.utils.JsonConverter;

/** Non-Thread-Safe **/
public class StaticBlockSingleton {

	private StaticBlockSingleton() {
	}

	private static final FactoryUseNameSpace instance;

	// static block initialization for exception handling
	static {
		instance = JsonConverter.deserialize(Paths.get("json", "ShapeFactoryNameSpace.json"),
				FactoryUseNameSpace.class);
	}

	public static FactoryUseNameSpace getInstance() {
		return instance;
	}
}
