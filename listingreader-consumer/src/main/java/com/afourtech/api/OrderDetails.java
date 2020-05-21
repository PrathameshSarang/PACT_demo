package com.afourtech.api;

import com.afourtech.model.CategoryData;
import com.afourtech.model.Order;
import com.fasterxml.jackson.annotation.JsonInclude;

public class OrderDetails {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Order order;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CategoryData category;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public OrderDetails(Order order, CategoryData category, String message) {
        this.order = order;
        this.category = category;
        this.message = message;
    }

    public OrderDetails(String msg) {
        this.order = null;
        this.message = msg ;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CategoryData getCategory() {
        return category;
    }

    public void setCategory(CategoryData category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ORDER DETAILS {" +
                    "status: {" + this.getMessage() + "}" +
                    ",order: {" + this.getOrder().toString() + "}" +
                    ",category: {" + this.getCategory().toString() + "}"+
                '}';
    }
}
