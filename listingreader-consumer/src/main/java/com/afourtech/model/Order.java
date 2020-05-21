package com.afourtech.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class Order {

    public Order(){
    }
    public Order(@NotNull Integer orderId, @NotNull Integer quanity, @NotBlank @Length(min = 2, max = 255) String categoryId, @NotNull Integer sellerId, @NotNull Integer buyerId, @NotBlank OrderStatus orderStatus) {
        this.orderId = orderId;
        this.quanity = quanity;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.orderStatus = orderStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQuanity() {
        return quanity;
    }

    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    @NotNull
    private Integer orderId;
    @NotNull
    private Integer quanity;
    @NotBlank
    @Length(min=2, max=255)
    private String categoryId;
    @NotNull
    private Integer sellerId;
    @NotNull
    private Integer buyerId;
    @NotBlank
    private OrderStatus orderStatus;



    @Override
    public String toString() {
        return "Order [id=" + orderId + ", quanity =" + quanity + ", categoryId="+ categoryId + ", buyerId=" + buyerId + "sellerId = "+sellerId+"]";
    }

}
