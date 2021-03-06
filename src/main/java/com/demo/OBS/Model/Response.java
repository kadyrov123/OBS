package com.demo.OBS.Model;

public class Response<T> {
    private String status;
    private T data;

    public Response(){

    }

    public Response(String status, T data){
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
