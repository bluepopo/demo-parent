package zy.code.demo.common.util;

import java.io.Serializable;

public class MyResult<T> implements Serializable, Cloneable{
    private static final long serialVersionUID = -42337313793857310L;
    private T data;
    private int code;
    private String message;
    private static final int SUCCESS_CODE = 0;


    public MyResult() {
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }
}
