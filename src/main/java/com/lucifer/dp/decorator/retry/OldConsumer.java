package com.lucifer.dp.decorator.retry;

import com.lucifer.dp.exception.ConnectionFailException;
import com.lucifer.dp.shape.Shape;
import com.lucifer.dp.utils.JsonConverter;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

public class OldConsumer {

    private final CloseableHttpClient httpClient;

    public OldConsumer(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Shape getShape() throws Exception {
        HttpGet httpGet = new HttpGet();
        Shape shape = null;
        for (int i = 0; i < 3; i++) {
            try {
                shape = getResponse(httpGet, Shape.class);
                break;
            } catch (Exception e) {
                if (i == 2) {
                    throw new Exception(e);
                }
            }
        }
        return shape;
    }

    private <T> T getResponse(HttpGet httpGet, Class<T> clazz) {

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new ConnectionFailException(String.format("Web Site seems to fail. Message: %s, StatusCode: %s", EntityUtils.toString(response.getEntity()), response.getStatusLine().getStatusCode()));
            }

            /** pay attention to the next three rows */
            try (InputStream ins = response.getEntity().getContent()) {
                return JsonConverter.stream2Obj(ins, clazz);
            }
            /** end */
        } catch (IOException e) {
            throw new ConnectionFailException(String.format("Http Get Relate Error. Message: %s", e));
        }

    }
}
