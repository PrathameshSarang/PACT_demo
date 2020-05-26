package com.afourtech.model;

import java.io.Serializable;

public class EmployeeResp implements Serializable {

  private Employee employee;

  public EmployeeResp(){

  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public EmployeeResp(Employee employee) {
    this.employee = employee;
  }


}
