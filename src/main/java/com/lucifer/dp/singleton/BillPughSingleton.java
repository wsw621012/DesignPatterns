package com.lucifer.dp.singleton;

import java.nio.file.Paths;

import com.lucifer.dp.factory.FactoryUseNameSpace;
import com.lucifer.dp.utils.JsonConverter;

/** Thread-Safe **/
public class BillPughSingleton {

	private BillPughSingleton() {
	}

	private static class SingletonHelper {
		private static final FactoryUseNameSpace instance;

		static {
			instance = JsonConverter.deserialize(Paths.get("json", "ShapeFactoryNameSpace.json"),
					FactoryUseNameSpace.class);
		}
	}

	public static FactoryUseNameSpace getInstance() {
		return SingletonHelper.instance;
	}
}
