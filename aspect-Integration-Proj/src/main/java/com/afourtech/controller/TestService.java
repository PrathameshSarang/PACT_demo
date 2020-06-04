package com.afourtech.controller;

public class TestService {

  public void helloWorldService(){
    System.out.println("==Hello World===");
  }

  public static void main(String[] args) {
    TestService testService=new TestService();
    testService.helloWorldService();
  }

}
