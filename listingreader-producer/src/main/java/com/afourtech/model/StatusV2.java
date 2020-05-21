package com.afourtech.model;

public class StatusV2 {

    private String status;
    private int messageId;
    private int code;

    public String getStatus() {
        return status;
    }

    public int getMessage() {
        return messageId;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", message='" + messageId + '\'' +
                ", code=" + code +
                '}';
    }

    public StatusV2(){
        status="ok";
        messageId=234;
        code=200;
    }



}
