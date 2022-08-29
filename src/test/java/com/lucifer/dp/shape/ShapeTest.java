package com.lucifer.dp.shape;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lucifer.dp.utils.JsonConverter;

public class ShapeTest {

	private InputStream prepareInputData() {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			l.add(String.format("%09d", i));
		}
		return new ByteArrayInputStream(JsonConverter.serialize(l).getBytes());
		
	}
	
	@Test
	public void testGson() {
		Gson gson = new Gson();
		try (InputStream ins = prepareInputData();
				JsonReader reader = new JsonReader(new InputStreamReader(ins, StandardCharsets.UTF_8))) {
			reader.beginArray();
	        while (reader.hasNext()) {
	            String text = gson.fromJson(reader, String.class);
	            System.out.println(text);
	        }
	        reader.endArray();
	        reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
