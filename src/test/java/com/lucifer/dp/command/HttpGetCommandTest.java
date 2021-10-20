package com.lucifer.dp.command;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;

import com.lucifer.dp.command.HttpGetCommand;
import com.lucifer.dp.exception.ConnectionFailException;
import com.lucifer.dp.utils.JsonConverter;

public class HttpGetCommandTest {

	private DailyList prepare() {
		DailyList list = new DailyList();
		list.value = new ArrayList<DailyList.Daily>();
		for (int i = 0; i < 4; i++) {
			DailyList.Daily d = new DailyList.Daily();
			d.id = Integer.toString(i);
			d.dateTimeUtc = LocalDate.now(Clock.systemUTC()).toString();
			d.type = "Daily";
			list.value.add(d);
		}
		
		return list;
	}

	@Test
	public void test() {

		CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
		HttpGet httpGet = mock(HttpGet.class);
		CloseableHttpResponse resp = mock(CloseableHttpResponse.class);
		StatusLine line = mock(StatusLine.class);
		HttpEntity entity = mock(HttpEntity.class);

		HttpGetCommand cmd = new HttpGetCommand(httpClient);

		DailyList originList = prepare();
		
		try (ByteArrayInputStream bais = new ByteArrayInputStream(JsonConverter.serialize(originList).getBytes())) {
			when(httpClient.execute(any(HttpGet.class))).thenReturn(resp);
			when(resp.getStatusLine()).thenReturn(line);
			when(line.getStatusCode()).thenReturn(200);
			when(resp.getEntity()).thenReturn(entity);
			when(entity.getContent()).thenReturn(bais);
			
			DailyList resultList = cmd.transfer(httpGet, ins -> {
				return JsonConverter.stream2Obj(ins, DailyList.class);
			});
			
			assertEquals(resultList.value.size(), originList.value.size());
			assertEquals(JsonConverter.serialize(resultList), JsonConverter.serialize(originList)); 
			
		} catch (IOException e) {
			fail();
		}
		
	}

	@Test(expected=ConnectionFailException.class)
	public void networkBreak() throws IOException {
		CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
		HttpGet httpGet = mock(HttpGet.class);
		
		HttpGetCommand cmd = new HttpGetCommand(httpClient);
		
		when(httpClient.execute(any(HttpGet.class))).thenThrow(IOException.class);
		
		cmd.transfer(httpGet, ins -> {
			return JsonConverter.stream2Obj(ins, DailyList.class);
		});
	}
	
	private static class DailyList {

		private static class Daily {
			public String id;
			public String type;
			public String dateTimeUtc;
		}

		public List<Daily> value;
	}
}
