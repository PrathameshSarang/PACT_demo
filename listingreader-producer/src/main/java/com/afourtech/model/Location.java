package com.afourtech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;



public class Location {

  private Double latitude;
  private Double longitude;
  private String zipCode;
  private String city;
  private String state;
  private String name;

  public Location() {
  }

  public Location(Double latitude, Double longitude, String zipCode, String city, String state, String name) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.zipCode = zipCode;
    this.city = city;
    this.state = state;
    this.name = name;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }
}
