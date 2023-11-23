package com.example.untitled7.common;

public class ResultImg {
    private String url;
    private boolean status;

    private ResultImg(String url, boolean status) {
        this.url = url;
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static <R> ResultImg ok(String url){
        return new ResultImg(url,true);
    }

    public static <R> ResultImg fail(){
        return new ResultImg(null,false);
    }
}
