package com.lucifer.dp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucifer.dp.exception.JsonConvertFailException;

public class JsonConverter {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static <T> T deserialize(Path path, Class<T> t) {
		try (InputStream ins = JsonConverter.class.getClassLoader()
				.getResourceAsStream(path.toString())) {

			return stream2Obj(ins, t);
		} catch (IOException e) {
			throw new JsonConvertFailException(e);
		}

	}

	public static <T> T stream2Obj(InputStream ins, Class<T> t) {
		try {
			return mapper.readValue(ins, t);
		} catch (IOException e) {
			throw new JsonConvertFailException(e);
		}

	}
	
	public static String serialize(Object t) {
		try {
			return mapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			throw new JsonConvertFailException(e);
		}
	}
}
