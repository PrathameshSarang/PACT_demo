package com.afourtech.controller;


import com.afourtech.api.CategoryDetails;
import com.afourtech.api.OrderDetails;
import com.afourtech.client.CategoryClient;
import com.afourtech.db.OrdersDB;
import com.afourtech.model.CategoryData;
import com.afourtech.model.Order;


public class OrderService {

    private final CategoryClient client;
    public OrderService(CategoryClient client){
        this.client = client;
    }

    public OrderDetails getOrderById(Integer id){
        Order order = OrdersDB.getOrder(id);
        if (order!=null) {
            CategoryDetails res = client.getCategoryById(order.getCategoryId());
            if (res.getStatus().getCode() == 200) {
                CategoryData categorydata = res.getData();
                return new OrderDetails(order, categorydata,"Order details Retrieved Successfully!");
            } else
                return new OrderDetails(res.getStatus().toString());
        }else
            return new OrderDetails("Order does not exist");
    }
}
