package com.cj.demo.dto;


public class ApiResponse<T> {

    private int code;
    private T data;

    // getters and setters

    public ApiResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}