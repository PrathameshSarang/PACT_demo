package com.sanity;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.afourtech.api.OrderDetails;
import com.afourtech.client.CategoryClient;
import com.afourtech.controller.OrderService;
import com.afourtech.model.Order;
import com.afourtech.model.OrderStatus;
import com.afourtech.utility.DataUtility;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.HashMap;


public class ListingReader_ConsumerSide {

    public int mockPort=8111;

    /**
     * @author Kingshuk Nandy
     * @description This will generate a mock provider service
     */
    @Rule
    public PactProviderRuleMk2 listingReader_provider=
            new PactProviderRuleMk2("listingReader_provider","localhost",mockPort,this);


    /**
     * @author Kingshuk Nandy
     * @description This will create a pact file
     */
    @Pact(consumer = "listingReader_Consumer")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        HashMap<String,String> headers=new HashMap<>();
        headers.put("Content-Type", "application/json");

       /* PactDslJsonRootValue jsonRootValue=new PactDslJsonRootValue();
        jsonRootValue.setValue(new JsonObject());*/
        //From the consumer side we tell that we need the following things in the response
        DataUtility dataUtility=new DataUtility();
        String responseBody1=dataUtility.getJsonRequestBody("prodyuctListingByOwner1.json").toString();
        String responseBody2=dataUtility.getJsonRequestBody("prodyuctListingByOwner2.json").toString();
        return builder.given("The value of ListingReader API catagory 5")
                .uponReceiving("GET REQUEST /internal/listingreader/v1/category/5")
                .path("/internal/listingreader/v1/category/5")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(responseBody1)
                .given("The value of ListingReader API catagory 6")
                .uponReceiving("GET REQUEST /internal/listingreader/v1/category/6")
                .path("/internal/listingreader/v1/category/6")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(responseBody2)
                .toPact();  // This creates a pact file
    }

    /*@Test
    @PactVerification
    public void givenGet_currencyExchange_shouldReturn200_with_properBody(){

        Client client= ClientBuilder.newClient();
        WebTarget webTarget=client.target(currencyExchange_mockProvider.getUrl() + "/internal/listingreader/v1/category/5");
        Response response=webTarget
                .request(MediaType.APPLICATION_JSON)
                .get();
        //Assert.assertEquals(response.getStatus(),200);
        WebTarget webTarget2=client.target(currencyExchange_mockProvider.getUrl() + "/internal/listingreader/v1/category/6");
        Response response2=webTarget2
                .request(MediaType.APPLICATION_JSON)
                .get();
    }
*/

    @Test
    @PactVerification
    public void givenGet_currencyExchange_shouldReturn200_with_properBody(){

        //For catagory Id 1
        Client client= ClientBuilder.newClient();

        CategoryClient categoryClient=new CategoryClient(client);
        categoryClient.setTarget(listingReader_provider.getUrl());
        categoryClient.setResource("/internal/listingreader/v1/category/");

        OrderService orderService=new OrderService(categoryClient);


        Order order_1=new Order(
                1,
                10,
                "5",
                100,
                200,
                OrderStatus.FULFILLED
        );


        OrderDetails orderDetails_1=orderService.getOrderById(order_1.getOrderId());
        Assert.assertEquals(order_1.toString(),orderDetails_1.getOrder().toString());
        Assert.assertEquals("Vehicles",orderDetails_1.getCategory().getLabel());

        int orderId_2=2;
        OrderDetails orderResponse_2=orderService.getOrderById(orderId_2);

    }


}
