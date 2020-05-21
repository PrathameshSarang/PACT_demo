package com.afourtech.model;

public class Status {

    private String status;
    private String message;
    private int code;

    public Status(){
    }

    public Status(String status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }





}
