package com.lucifer.dp.decorator.retry;

import com.lucifer.dp.shape.Shape;
import org.apache.http.client.methods.HttpGet;

public class Retry implements Command {
    private final Command cmd;

    public Retry(Command cmd) {
        this.cmd = cmd;
    }
    @Override
    public Shape getShape(HttpGet httpGet) throws Exception {
        Shape shape = null;
        for (int i = 0; i < 3; i++) {
            try {
                shape = cmd.getShape(httpGet);
                break;
            } catch (Exception e) {
                if (i == 2) {
                    throw new Exception(e);
                }
            }
        }
        return shape;
    }
}
