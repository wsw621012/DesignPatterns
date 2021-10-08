package com.lucifer.dp.command.traditional;

import com.lucifer.dp.utils.JsonConverter;
import java.io.InputStream;

public class JsonConv2Cust implements RespCommand {

    @Override
    public <T> T resp(InputStream ins, Class<T> clazz) {
        return JsonConverter.stream2Obj(ins, clazz);
    }
}
