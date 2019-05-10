package com.xhe.common.utils;

import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Xhe
 * Date: 2018/5/11
 * Time: 8:58
 * Desc: 返回的数据
 */
public class R extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    public R(){
        put("code",0);
        put("msg","success");
    }

    public static R error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "网络错误！");
    }

    public static R error(String msg){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }

    public static R error(int code, String msg) {
        R tr = new R();
        tr.put("code", code);
        tr.put("msg", msg);
        return tr;
    }

    public static R ok(String msg){
        R tr = new R();
        tr.put("msg",msg);
        return tr;
    }
    public static R ok(Object obj){
        R tr = new R();
        tr.put("msg","success");
        tr.put("data",obj);
        return tr;
    }
    public static R ok(String msg,Object obj){
        R tr = new R();
        tr.put("msg",msg);
        tr.put("data",obj);
        return tr;
    }

    public static R ok(Map<String, Object> map) {
        R tr = new R();
        tr.putAll(map);
        return tr;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
