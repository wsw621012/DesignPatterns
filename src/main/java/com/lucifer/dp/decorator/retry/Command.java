package com.lucifer.dp.decorator.retry;

import com.lucifer.dp.shape.Shape;
import org.apache.http.client.methods.HttpGet;

public interface Command {

    Shape getShape(HttpGet httpGet) throws Exception;
}
