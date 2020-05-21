package com.afourtech.model;

public class Status {

    private String status;
    private String message;
    private int code;

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

    public Status(){
        status="ok";
        message="OK";
        code=200;
    }



}
