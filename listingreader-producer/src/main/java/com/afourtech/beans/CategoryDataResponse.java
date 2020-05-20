package com.afourtech.beans;

import com.afourtech.model.CategoryData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CategoryDataResponse {

    public CategoryDataResponse() {}

    private int status;
    private String message;
    private CategoryData[] data;

    //TODO: Implement parametrized constructor
    public CategoryDataResponse(int status, int message, CategoryData[] data){
        throw new NotImplementedException();
    }

//    @JsonProperty
//    public Long getId() {
//        return id;
//    }
//
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @JsonProperty
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    @JsonView
//    @JsonProperty
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    @JsonProperty
//    public int getConversionMultiple() {
//        return conversionMultiple;
//    }
//
//    public void setConversionMultiple(int conversionMultiple) {
//        this.conversionMultiple = conversionMultiple;
//    }
//
//    @JsonProperty
//    public int getQuantity() {
//        return quantity;
//    }
//
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    @JsonProperty
//    public int getTotalCalculatedAmount() {
//        return totalCalculatedAmount;
//    }
//
//    public void setTotalCalculatedAmount(int totalCalculatedAmount) {
//        this.totalCalculatedAmount = totalCalculatedAmount;
//    }
//
//    @JsonProperty
//    public String getExchangeEnvironmentInfo() {
//        return exchangeEnvironmentInfo;
//    }
//
//    public void setExchangeEnvironmentInfo(String exchangeEnvironmentInfo) {
//        this.exchangeEnvironmentInfo = exchangeEnvironmentInfo;
//    }
//
//    @JsonProperty
//    public String getConversionEnvironmentInfo() {
//        return conversionEnvironmentInfo;
//    }
//
//    public void setConversionEnvironmentInfo(String conversionEnvironmentInfo) {
//        this.conversionEnvironmentInfo = conversionEnvironmentInfo;
//    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }
}
