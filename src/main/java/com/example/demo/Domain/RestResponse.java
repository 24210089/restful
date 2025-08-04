package com.example.demo.Domain;

public class RestResponse<T> {
    private int statusCode; // HTTP status (200, 400, 500...)
    private Object message; // Thông điệp mô tả
    private T data; // Dữ liệu (success case)
    private Object error; // Lỗi chi tiết (error case)

    // Constructors
    public RestResponse() {
    }

    // Getters & Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
