package com.afourtech.controller;


import com.afourtech.api.CategoryDataResponse;
import com.afourtech.api.OrderResponse;
import com.afourtech.client.CategoryClient;
import com.afourtech.db.OrdersDB;
import com.afourtech.model.CategoryData;
import com.afourtech.model.Order;


public class OrderService {

    private final CategoryClient client;
    public OrderService(CategoryClient client){
        this.client = client;
    }

    public OrderResponse getOrderById(Integer id){
        Order order = OrdersDB.getOrder(id);
        if (order!=null) {
            CategoryDataResponse res = client.getCategoryById(order.getCategoryId());
            if (res.getStatus().getCode() == 200) {
                CategoryData categorydata = res.getData();
                return new OrderResponse(order, categorydata,"Order details Retrieved Successfully!");
            } else
                return new OrderResponse(res.getStatus().toString());
        }else
            return new OrderResponse("Order does not exist");
    }
}
