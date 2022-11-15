package com.xxx.springboot.exceptions;

public class ParamsExceptions extends RuntimeException{

    private Integer code = 300;
    private String msg = "参数异常!";

    public ParamsExceptions() {
        super("参数异常!");
    }

    public ParamsExceptions(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ParamsExceptions(Integer code) {
        super("参数异常!");
        this.code = code;
    }

    public ParamsExceptions(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
