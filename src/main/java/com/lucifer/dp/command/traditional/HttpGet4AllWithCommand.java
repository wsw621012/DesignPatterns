package com.lucifer.dp.command.traditional;

import com.lucifer.dp.exception.ConnectionFailException;
import com.lucifer.dp.utils.JsonConverter;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

public class HttpGet4AllWithCommand {
    private final CloseableHttpClient httpClient;

    public HttpGet4AllWithCommand(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public <T> T transfer(HttpGet httpGet, RespCommand cmd, Class<T> clazz) {

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new ConnectionFailException(String.format("Web Site seems to fail. Message: %s, StatusCode: %s", EntityUtils.toString(response.getEntity()), response.getStatusLine().getStatusCode()));
            }

            /** pay attention to the next three rows */
            try (InputStream ins = response.getEntity().getContent()) {
                return cmd.resp(ins, clazz);
            }
            /** end */
        } catch (IOException e) {
            throw new ConnectionFailException(String.format("Http Get Relate Error. Message: %s", e));
        }
    }
}
