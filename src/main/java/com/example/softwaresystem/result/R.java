package com.example.softwaresystem.result;

import lombok.Data;

@Data
public class R<T> {
    private String msg;
    private int code;
    private Object data;
    public static R success(Object o,String msg){
       R r = new R();
       r.setCode(1);
       r.setData(o);
       r.setMsg(msg);
        return r;
    }
    public static R error(String msg){
        R r = new R();
        r.setCode(0);
        r.setData(null);
        r.setMsg(msg);
        return r;
    }
}
