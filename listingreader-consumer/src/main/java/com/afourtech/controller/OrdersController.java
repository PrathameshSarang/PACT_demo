package com.afourtech.controller;

import com.afourtech.api.OrderResponse;
import com.afourtech.client.CategoryClient;
import com.afourtech.db.OrdersDB;
import com.afourtech.model.Order;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Set;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrdersController {

    private final Validator validator;
    private final CategoryClient client;
    public OrdersController(Validator validator, CategoryClient client) {
        this.validator = validator;
        this.client = client;
    }

    @GET
    @Path("/")
    public Response getEmployees() {
        return Response.ok(OrdersDB.getOrders()).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrderById(@PathParam("id") Integer id) {
        OrderService service = new OrderService(client);
        OrderResponse response =  service.getOrderById(id);
        if (response.getOrder() != null)
            return Response.ok(response).build();
        else
            return Response.status(Response.Status.NOT_FOUND.getStatusCode(),response.getMessage()).build();
    }


    @PUT
    @Path("/{id}")
    public Response updateOrderById(@PathParam("id") Integer id, Order order) {
        // validation
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        Order e = OrdersDB.getOrder(order.getOrderId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<Order> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            order.setOrderId(id);
            OrdersDB.updateOrder(id, order);
            return Response.ok(order).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

}
