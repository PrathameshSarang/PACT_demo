package com.afourtech.db;

import com.afourtech.model.Order;
import com.afourtech.model.OrderStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrdersDB {

    public static HashMap<Integer, Order> order_lst = new HashMap<>();

    static{
        order_lst.put(1, new Order(1, 10,"5",100,200, OrderStatus.FULFILLED));
        order_lst.put(2, new Order(2, 5,"6",100,202,OrderStatus.FULFILLED));
        order_lst.put(3, new Order(3, 10,"5.1",100,250, OrderStatus.CANCELLED));
    }

    public static List<Order> getOrders(){
        return new ArrayList<Order>(order_lst.values());
    }

    public static Order getOrder(Integer id){
        return order_lst.get(id);
    }

    public static void updateOrder(Integer id, Order order){
        order_lst.put(id, order);
    }

    public static void cancelOrder(Integer id){
        order_lst.remove(id);
    }

    public static void createOrder(Order order){
        // Some logic to the get the max id and put
        int new_order_id = order_lst.size();
        // Set the new order id
        order.setOrderId(new_order_id);
        order_lst.put(new_order_id, order);
    }
}
