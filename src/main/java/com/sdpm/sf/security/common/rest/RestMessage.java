package com.sdpm.sf.security.common.rest;

/**
 * REST消息封装
 *
 * @author rukey
 */
public class RestMessage {

    private boolean success = true;

    private int code = 0;

    private String msg = "操作成功";

    private Object data;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

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

}
