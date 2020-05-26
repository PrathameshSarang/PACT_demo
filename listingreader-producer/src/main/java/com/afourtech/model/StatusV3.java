package com.afourtech.model;

public class StatusV3 {
  private String status;
  private int code;
  public String getStatus() {
    return status;
  }
  public int getCode() {
    return code;
  }
  @Override
  public String toString() {
    return "Status{" +
        "status='" + status + '\'' +
        ", code=" + code +
        '}';
  }
  public StatusV3() {
    status = "ok";
    code = 200;
  }
}
