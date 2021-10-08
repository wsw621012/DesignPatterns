package com.lucifer.dp.command.traditional;

public class CustResp {
    int id;
    String name;

    public CustResp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
