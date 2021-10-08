package com.lucifer.dp.command.traditional;
import java.io.InputStream;

public interface RespCommand {
    <T> T resp(InputStream ins, Class<T> clazz);
}
