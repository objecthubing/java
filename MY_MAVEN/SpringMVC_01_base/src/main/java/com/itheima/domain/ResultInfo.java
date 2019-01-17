package com.itheima.domain;

public class ResultInfo {
    private  int status ;
    private String msg ;
    private Object data ;

    public ResultInfo() {
    }

    public ResultInfo(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResultInfo(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
