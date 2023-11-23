package com.example.untitled7.common;

public class Result {
    private Object data;
    private boolean status;

    private Result(Object data, boolean status) {
        this.data = data;
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static Result ok(Object data){
        return new Result(data,true);
    }

    public static Result fail(){
        return new Result("fail",false);
    }
}
