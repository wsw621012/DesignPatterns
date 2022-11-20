package com.lucifer.dp.decorator.retry;

import com.lucifer.dp.shape.Shape;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class RetryTest {


    @Test
    public void testRetry() {
        CloseableHttpClient httpClient = Mockito.mock(CloseableHttpClient.class);
        Command cmd = new Retry(new NewConsumer(httpClient));
        HttpGet httpGet = Mockito.mock(HttpGet.class);
        try {
            Shape shape = cmd.getShape(httpGet);
        } catch (Exception e) {

        }
    }
}