package com.lucifer.dp.singleton;

import java.nio.file.Paths;

import com.lucifer.dp.factory.FactoryUseNameSpace;
import com.lucifer.dp.utils.JsonConverter;

/** Thread-Safe **/
public class LazyInitializedSingleton {

	private LazyInitializedSingleton() {
	}

	private static volatile FactoryUseNameSpace instance;

	public static FactoryUseNameSpace getInstance() {

		if (null == instance) {
			synchronized (LazyInitializedSingleton.class) {
				if (null == instance) {
					instance = JsonConverter.deserialize(
							Paths.get("json", "ShapeFactoryNameSpace.json"),
							FactoryUseNameSpace.class);
				}
			}
		}
		return instance;
	}
}
