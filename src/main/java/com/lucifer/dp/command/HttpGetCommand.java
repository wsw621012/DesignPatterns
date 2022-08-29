package com.lucifer.dp.command;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import com.lucifer.dp.exception.ConnectionFailException;

public class HttpGetCommand {

	private final CloseableHttpClient httpClient;
	
	public HttpGetCommand(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}
	
	public <R> R transfer(HttpGet httpGet, Function<InputStream, R> func) {
		
		try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new ConnectionFailException(String.format("Web Site seems to fail. Message: %s, StatusCode: %s", EntityUtils.toString(response.getEntity()), response.getStatusLine().getStatusCode()));
			}

			try (InputStream ins = response.getEntity().getContent()) {
				return func.apply(ins);
			}
		} catch (IOException e) {
			throw new ConnectionFailException(String.format("Http Get Relate Error. Message: %s", e));
		}
	}
	
	public void process(HttpGet httpGet, Consumer<InputStream> func) {
		
		try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new ConnectionFailException(String.format("Web Site seems to fail. Message: %s, StatusCode: %s", EntityUtils.toString(response.getEntity()), response.getStatusLine().getStatusCode()));
			}

			try (InputStream ins = response.getEntity().getContent()) {
				func.accept(ins);
			}
		} catch (IOException e) {
			throw new ConnectionFailException(String.format("Http Get Relate Error. Message: %s", e));
		}
	}
}
