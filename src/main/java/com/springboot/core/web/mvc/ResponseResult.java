package com.springboot.core.web.mvc;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:55
 * @Package: com.springboot.core.web.mvc
 */

public class ResponseResult {

    private int code = 20000;
    private String msg;
    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
